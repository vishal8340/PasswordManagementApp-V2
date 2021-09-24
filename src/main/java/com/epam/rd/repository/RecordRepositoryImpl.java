package com.epam.rd.repository;

import com.epam.rd.entity.Account;
import com.epam.rd.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface RecordRepositoryImpl extends JpaRepository<Record, Integer> {
    List<Record> findByAccount(Account account);

    boolean existsByUrlAndAccount(String url, Account account);

    Record findByUrlAndAccount(String url, Account account);

    void deleteByUrlAndAccount(String url, Account account);
}
