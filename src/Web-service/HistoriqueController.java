package com.groupeisi.Examen_serviceWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class HistoriqueServiceImpl implements HistoriqueService {

    @Autowired
    private SearchItemRepository searchItemRepository;

    @Override
    public void saveSearchItem(Map<String, String> request, Map<String, String> response) {
        SearchItem searchItem = new SearchItem();
        searchItem.setSearchDate(LocalDateTime.now());
        searchItem.setRequest(request);
        searchItem.setResponse(response);
        searchItemRepository.save(searchItem);
    }

    @Override
    public List<SearchItem> getHistorique() {
        return searchItemRepository.findAll();
    }
}
