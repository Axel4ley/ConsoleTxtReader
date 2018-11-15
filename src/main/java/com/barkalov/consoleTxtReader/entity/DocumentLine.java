package com.barkalov.consoleTxtReader.entity;

import java.io.Serializable;

public class DocumentLine implements Serializable {
    private Long id;
    private String line;
    private Document document;
    private Integer length;
    private String longestWord;
    private String shortestWord;
    private Double average;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getLongestWord() {
        return longestWord;
    }

    public void setLongestWord(String longestWord) {
        this.longestWord = longestWord;
    }

    public String getShortestWord() {
        return shortestWord;
    }

    public void setShortestWord(String shortestWord) {
        this.shortestWord = shortestWord;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "DocumentLine{" +
                "id=" + id +
                ", line='" + line + '\'' +
                ", document=" + document +
                ", length=" + length +
                ", longestWord='" + longestWord + '\'' +
                ", shortestWord='" + shortestWord + '\'' +
                ", average=" + average +
                '}';
    }
}
