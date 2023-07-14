package com.groupeisi.Examen_serviceWeb;

@RestController
@RequestMapping("/dayfinder")
public class DateController {

    @Autowired
    private HistoriqueService historiqueService;

    @PostMapping
    public ResponseEntity<Map<String, String>> getDayOfWeek(@RequestBody Map<String, String> request) {
        String dateStr = request.get("date");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        String dayOfWeek = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.FRANCE);

        Map<String, String> response = new HashMap<>();
        response.put("date", date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        response.put("dayOfWeek", dayOfWeek);

        // Enregistrement de l'historique
        historiqueService.saveSearchItem(request, response);

        return ResponseEntity.ok(response);
    }
}

