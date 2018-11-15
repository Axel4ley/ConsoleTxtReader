package com.barkalov.consoleTxtReader.entity;

import java.io.Serializable;
import java.util.List;

public class Document implements Serializable {
    private Long id;
    private String name;
    private int lineCount;
    private List<DocumentLine> documentLines;

    public Document() {
    }

    public Document(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }

    public List<DocumentLine> getDocumentLines() {
        return documentLines;
    }

    public void setDocumentLines(List<DocumentLine> documentLines) {
        this.documentLines = documentLines;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lineCount=" + lineCount +
                ", documentLines=" + documentLines +
                '}';
    }
}
