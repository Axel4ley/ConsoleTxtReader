package com.barkalov.consoleTxtReader.dao;

import com.barkalov.consoleTxtReader.entity.Document;

import java.util.List;

public interface DocumentDao {
    void insertDocumentWithLines(List<Document> document);
}
