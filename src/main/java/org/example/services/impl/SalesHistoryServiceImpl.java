package org.example.services.impl;

import org.example.DTOs.SalesHistoryDTO;
import org.example.models.SalesHistory;
import org.example.repositories.SalesHistoryRepository;
import org.example.services.SalesHistoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SalesHistoryServiceImpl implements SalesHistoryService<Integer> {

    @Autowired
    private SalesHistoryRepository salesHistoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SalesHistoryDTO register(SalesHistoryDTO SalesHistory) {
        return modelMapper.map(
                salesHistoryRepository.save(modelMapper.map(SalesHistory, SalesHistory.class)),
                SalesHistoryDTO.class
        );
    }

    @Override
    public SalesHistoryDTO update(SalesHistoryDTO salesHistory, int id) {
        salesHistoryRepository.update(id, salesHistory.getCount(), salesHistory.getProduct(), salesHistory.getStaff());
        return modelMapper.map(this.findSalesHistory(id), SalesHistoryDTO.class);
    }

    @Override
    public void expel(SalesHistoryDTO SalesHistory) {
        salesHistoryRepository.delete(modelMapper.map(SalesHistory, SalesHistory.class));
    }

    @Override
    public void expel(Integer id) {
        salesHistoryRepository.deleteById(id);
    }


    @Override
    public Optional<SalesHistoryDTO> findSalesHistory(Integer id) {
        return Optional.ofNullable(modelMapper.map(salesHistoryRepository.findById(id), SalesHistoryDTO.class));
    }

    @Override
    public List<SalesHistoryDTO> findSalesHistorys() {
        Iterable<SalesHistory> SalesHistorys = salesHistoryRepository.findAll();
        List<SalesHistoryDTO> SalesHistorysDTO = new ArrayList<>();
        for (SalesHistory SalesHistory: SalesHistorys) {
            SalesHistorysDTO.add(modelMapper.map(SalesHistory, SalesHistoryDTO.class));
        }
        return SalesHistorysDTO;
    }
}