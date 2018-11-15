package com.barkalov.consoleTxtReader.service;

import com.barkalov.consoleTxtReader.entity.Document;

import java.util.List;

public interface DocumentService {
    public List<Document> getDocumentsWithStatistic(String directoryUrl);
}
