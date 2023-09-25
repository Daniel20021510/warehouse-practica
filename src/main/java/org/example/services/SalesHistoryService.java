package org.example.services;


import org.example.DTOs.SalesHistoryDTO;

import java.util.List;
import java.util.Optional;

public interface SalesHistoryService<ID> {

    SalesHistoryDTO register(SalesHistoryDTO salesHistory);

    SalesHistoryDTO update(SalesHistoryDTO salesHistory, int id);

    void expel(SalesHistoryDTO salesHistory);

    void expel(ID id);

    Optional<SalesHistoryDTO> findSalesHistory(ID id);

    List<SalesHistoryDTO> findSalesHistorys();
}

