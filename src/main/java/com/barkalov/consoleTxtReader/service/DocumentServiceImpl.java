package com.barkalov.consoleTxtReader.service;

import com.barkalov.consoleTxtReader.entity.Document;
import com.barkalov.consoleTxtReader.entity.DocumentLine;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service("documentService")
public class DocumentServiceImpl implements DocumentService {

    @Override
    public List<Document> getDocumentsWithStatistic(String directoryUrl) {
            List<Document> result = new ArrayList<>();
            List targetUrlsFromDirectory = getAllFilesUrlsFromDirectory(directoryUrl);
            if (targetUrlsFromDirectory.size() == 0) {
                return result;
            }

            targetUrlsFromDirectory.stream().forEach(value -> {
                String fileName = value.toString();
                Document document = new Document(fileName.substring(fileName.lastIndexOf("/") + 1));
//                Document document = new Document(fileName.substring(fileName.lastIndexOf("\\") + 1)); // For Windows users

                List<String> linesFromFile = readFileAndSplitByLines(value.toString());
                document.setDocumentLines(getLines(linesFromFile, document));
                document.setLineCount(linesFromFile.size());
                result.add(document);
            });

            return result;
        }

        private List getAllFilesUrlsFromDirectory(String directoryUrl) {
            List result = null;
            try {
                result = Files.walk(Paths.get(directoryUrl)).
                        filter(Files::isRegularFile).
                        map(Path::toFile).
                        collect(Collectors.toList());
            } catch (IOException e) {
                return new ArrayList();
            }

            return result;
        }

        private List<String> readFileAndSplitByLines(String directoryUrl) {
            List<String> result = new ArrayList<String>();
            try (Stream<String> stream = Files.lines(Paths.get(directoryUrl))) {
                stream.forEach(result::add);
            } catch (IOException e) {
                System.out.println("File not found. URL: " + directoryUrl);
            }
            return result;
        }

        private List<DocumentLine> getLines(List<String> lines, Document document) {
            List<DocumentLine> result = new ArrayList<DocumentLine>();
            lines.stream().forEach(value -> {
                result.add(getLineWithStatistic(value, document));
            });
            return result;
        }

        private DocumentLine getLineWithStatistic(String line, Document document) {
            List<String> words = Arrays.asList(line.split("[\\s,.!?-]+"));
            DocumentLine result = new DocumentLine();
            result.setLine(line);
            result.setDocument(document);
            result.setLength(words.size());
            result.setLongestWord(words.
                    stream().
                    max(Comparator.comparingInt(String::length)).
                    get());
            result.setShortestWord(words.
                    stream().
                    min(Comparator.comparingInt(String::length)).get());
            result.setAverage(words.
                    stream().
                    collect(Collectors.summarizingInt(String::length))
                    .getAverage());

            return result;
        }
    }

