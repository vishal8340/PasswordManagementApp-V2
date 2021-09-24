package com.epam.rd.service;

import com.epam.rd.entity.Record;
import com.epam.rd.repository.RecordRepositoryImpl;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RecordServiceTest {
    @InjectMocks
    RecordServiceImpl recordServiceImpl;
    @Mock
    RecordRepositoryImpl recordRepositoryImpl;

    @Test
    @DisplayName("record should be added")
    public void recordShouldBeAdded() {
        Record record = new Record("", "", "", "");
        Record record1 = new Record("", "", "", "");
        when(recordRepositoryImpl.save(any())).thenReturn(record1);
        Assertions.assertNotNull(recordServiceImpl.addRecord(record));
    }

    @Test
    @DisplayName("record should be added1")
    public void recordShouldBeAdded1() {
        Record record = new Record("", "", "", "");
        Record record1 = null;
        when(recordRepositoryImpl.save(any())).thenReturn(record1);
        Assertions.assertFalse(recordServiceImpl.addRecord(record));
    }

    @Test
    @DisplayName("record should be find based on url")
    public void recordShouldBeFindBasedOnUrl() {
        Record record = new Record("", "", "www.google.com", "");
        Record record1 = new Record("", "Vishal834019", "", "");
        when(recordRepositoryImpl.findByUrlAndAccount(any(), any())).thenReturn(record1);
        Assertions.assertEquals(record1, recordServiceImpl.findRecordBasedOnUrl(record));
    }

    @Test
    @DisplayName("record should be find based on url")
    public void recordShouldBeFindBasedOnUrl1() {
        Record record = new Record("", "", "www.google.com", "");
        Record record1 = new Record("", "Vishal834019", "", "");
        when(recordRepositoryImpl.findByUrlAndAccount(any(), any())).thenReturn(record1);
        Assertions.assertNotEquals(record, recordServiceImpl.findRecordBasedOnUrl(record));
    }

    @Test
    @DisplayName("all records should be find")
    public void allRecordsShouldBeFind() {
        List<Record> recordList = List.of(new Record("", "", "www.google.com", ""));
        when(recordRepositoryImpl.findByAccount(any())).thenReturn(recordList);
        Assertions.assertEquals(recordList, recordServiceImpl.findAllRecords());
    }

    @Test
    @DisplayName("all records should be find1")
    public void allRecordsShouldBeFind1() {
        List<Record> recordList = List.of(new Record("", "", "www.google.com", ""));
        when(recordRepositoryImpl.findByAccount(any())).thenReturn(null);
        Assertions.assertNotEquals(recordList, recordServiceImpl.findAllRecords());
    }

    @Test
    @DisplayName("record should be updated")
    public void recordShouldBeUpdated() {
        Record record = new Record("", "", "", "");
        Record record1 = null;
        when(recordRepositoryImpl.save(any())).thenReturn(record1);
        Assertions.assertFalse(recordServiceImpl.updateRecord(record));
    }

    @Test
    @DisplayName("record should be updated1")
    public void recordShouldBeUpdated1() {
        Record record = new Record("", "", "", "");
        Record record1 = new Record("", "", "", "");
        when(recordRepositoryImpl.save(any())).thenReturn(record1);
        Assertions.assertNotNull(recordServiceImpl.updateRecord(record));
    }

    @Test
    @DisplayName("record should be deleted")
    public void recordShouldBeDeleted() {
        Record record = new Record("", "", "", "");
        Record record1 = new Record("", "", "", "");
        when(recordRepositoryImpl.findByUrlAndAccount(any(), any())).thenReturn(record1);
        Assertions.assertTrue(recordServiceImpl.deleteRecordBasedOnUrl(record));
    }

    @Test
    @DisplayName("record should be deleted1")
    public void recordShouldBeDeleted1() {
        Record record = new Record("", "", "", "");
        when(recordRepositoryImpl.findByUrlAndAccount(any(), any())).thenReturn(null);
        Assertions.assertFalse(recordServiceImpl.deleteRecordBasedOnUrl(record));
    }
}
