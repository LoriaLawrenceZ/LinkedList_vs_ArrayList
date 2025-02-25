package org.example.controller;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class dump {

    private static final int ELEMENTS = 100_000;

    public Object[][] retornaDados() {
        List<Pair<String, Long>> benchmarkArrayInfo = benchmarkList(new ArrayList<>(), "ArrayList");
        List<Pair<String, Long>> benchmarkLinkedInfo = benchmarkList(new LinkedList<>(), "LinkedList");
        Object [][] dados = {
                {benchmarkArrayInfo.get(0).getLeft(), benchmarkArrayInfo.get(0).getRight() + " ns", benchmarkLinkedInfo.get(0).getRight() + " ns", (benchmarkArrayInfo.get(0).getRight() < benchmarkLinkedInfo.get(0).getRight()) ? "ArrayList by " + (benchmarkLinkedInfo.get(0).getRight() - benchmarkArrayInfo.get(0).getRight()) + " ns" : "LinkedList by " + (benchmarkArrayInfo.get(0).getRight() - benchmarkLinkedInfo.get(0).getRight()) + " ns"},
                {benchmarkArrayInfo.get(1).getLeft(), benchmarkArrayInfo.get(1).getRight() + " ns", benchmarkLinkedInfo.get(1).getRight() + " ns", (benchmarkArrayInfo.get(1).getRight() < benchmarkLinkedInfo.get(1).getRight()) ? "ArrayList by " + (benchmarkLinkedInfo.get(1).getRight() - benchmarkArrayInfo.get(1).getRight()) + " ns" : "LinkedList by " + (benchmarkArrayInfo.get(1).getRight() - benchmarkLinkedInfo.get(1).getRight()) + " ns"},
                {benchmarkArrayInfo.get(2).getLeft(), benchmarkArrayInfo.get(2).getRight() + " ns", benchmarkLinkedInfo.get(2).getRight() + " ns", (benchmarkArrayInfo.get(2).getRight() < benchmarkLinkedInfo.get(2).getRight()) ? "ArrayList by " + (benchmarkLinkedInfo.get(2).getRight() - benchmarkArrayInfo.get(2).getRight()) + " ns" : "LinkedList by " + (benchmarkArrayInfo.get(2).getRight() - benchmarkLinkedInfo.get(2).getRight()) + " ns"},
                {benchmarkArrayInfo.get(3).getLeft(), benchmarkArrayInfo.get(3).getRight() + " ns", benchmarkLinkedInfo.get(3).getRight() + " ns", (benchmarkArrayInfo.get(3).getRight() < benchmarkLinkedInfo.get(3).getRight()) ? "ArrayList by " + (benchmarkLinkedInfo.get(3).getRight() - benchmarkArrayInfo.get(3).getRight()) + " ns" : "LinkedList by " + (benchmarkArrayInfo.get(3).getRight() - benchmarkLinkedInfo.get(3).getRight()) + " ns"},
                {benchmarkArrayInfo.get(4).getLeft(), benchmarkArrayInfo.get(4).getRight() + " ns", benchmarkLinkedInfo.get(4).getRight() + " ns", (benchmarkArrayInfo.get(4).getRight() < benchmarkLinkedInfo.get(4).getRight()) ? "ArrayList by " + (benchmarkLinkedInfo.get(4).getRight() - benchmarkArrayInfo.get(4).getRight()) + " ns" : "LinkedList by " + (benchmarkArrayInfo.get(4).getRight() - benchmarkLinkedInfo.get(4).getRight()) + " ns"},
                {benchmarkArrayInfo.get(5).getLeft(), benchmarkArrayInfo.get(5).getRight() + " ns", benchmarkLinkedInfo.get(5).getRight() + " ns", (benchmarkArrayInfo.get(5).getRight() < benchmarkLinkedInfo.get(5).getRight()) ? "ArrayList by " + (benchmarkLinkedInfo.get(5).getRight() - benchmarkArrayInfo.get(5).getRight()) + " ns" : "LinkedList by " + (benchmarkArrayInfo.get(5).getRight() - benchmarkLinkedInfo.get(5).getRight()) + " ns"},
                {benchmarkArrayInfo.get(6).getLeft(), benchmarkArrayInfo.get(6).getRight() + " ns", benchmarkLinkedInfo.get(6).getRight() + " ns", (benchmarkArrayInfo.get(6).getRight() < benchmarkLinkedInfo.get(6).getRight()) ? "ArrayList by " + (benchmarkLinkedInfo.get(6).getRight() - benchmarkArrayInfo.get(6).getRight()) + " ns" : "LinkedList by " + (benchmarkArrayInfo.get(6).getRight() - benchmarkLinkedInfo.get(6).getRight()) + " ns"},
                {benchmarkArrayInfo.get(7).getLeft(), benchmarkArrayInfo.get(7).getRight() + " ns", benchmarkLinkedInfo.get(7).getRight() + " ns", (benchmarkArrayInfo.get(7).getRight() < benchmarkLinkedInfo.get(7).getRight()) ? "ArrayList by " + (benchmarkLinkedInfo.get(7).getRight() - benchmarkArrayInfo.get(7).getRight()) + " ns" : "LinkedList by " + (benchmarkArrayInfo.get(7).getRight() - benchmarkLinkedInfo.get(7).getRight()) + " ns"},
                {benchmarkArrayInfo.get(8).getLeft(), benchmarkArrayInfo.get(8).getRight() + " ns", benchmarkLinkedInfo.get(8).getRight() + " ns", (benchmarkArrayInfo.get(8).getRight() < benchmarkLinkedInfo.get(8).getRight()) ? "ArrayList by " + (benchmarkLinkedInfo.get(8).getRight() - benchmarkArrayInfo.get(8).getRight()) + " ns" : "LinkedList by " + (benchmarkArrayInfo.get(8).getRight() - benchmarkLinkedInfo.get(8).getRight()) + " ns"},
        };

        return dados;
    }

    private List<Pair<String, Long>> benchmarkList(List<Integer> pList, String pListType) {
        List<Pair<String, Long>> benchmarkInfo = new ArrayList<>();
        long start;
        long end;
        long totalTime;

        // **Creation Benchmark**
        start = System.nanoTime();
        for (int i = 0; i < ELEMENTS; i++) {
            pList.add(i);
        }
        end = System.nanoTime();
        totalTime = calculateTime(start, end);
        addToPair(benchmarkInfo, "Creation Time", totalTime);

        // **Insertion at Beginning**
        start = System.nanoTime();
        pList.add(0, -1);
        end = System.nanoTime();
        totalTime = calculateTime(start, end);
        addToPair(benchmarkInfo, "Insertion at Beggining", totalTime);

        // **Insertion at Middle**
        start = System.nanoTime();
        pList.add(ELEMENTS / 2, -1);
        end = System.nanoTime();
        totalTime = calculateTime(start, end);
        addToPair(benchmarkInfo, "Insertion at Middle", totalTime);
        // **Insertion at End**
        start = System.nanoTime();
        pList.add(-1);
        end = System.nanoTime();
        totalTime = calculateTime(start, end);
        addToPair(benchmarkInfo, "Insertion at End", totalTime);

        // **Deletion from Beginning**
        start = System.nanoTime();
        pList.remove(0);
        end = System.nanoTime();
        totalTime = calculateTime(start, end);
        addToPair(benchmarkInfo, "Deletion from Beggining", totalTime);

        // **Deletion from Middle**
        start = System.nanoTime();
        pList.remove(ELEMENTS / 2);
        end = System.nanoTime();
        totalTime = calculateTime(start, end);
        addToPair(benchmarkInfo, "Insertion from Middle", totalTime);

        // **Deletion from End**
        start = System.nanoTime();
        pList.remove(pList.size() - 1);
        end = System.nanoTime();
        totalTime = calculateTime(start, end);
        addToPair(benchmarkInfo, "Insertion from End", totalTime);

        // **Searching an Element**
        start = System.nanoTime();
        boolean found = pList.contains(ELEMENTS / 2);
        end = System.nanoTime();
        totalTime = calculateTime(start, end);
        addToPair(benchmarkInfo, "Search Operation (Found: " + found + ")", totalTime);

        // **Conversion to Another List**
        start = System.nanoTime();
        List<Integer> newList = new ArrayList<>(pList);
        end = System.nanoTime();
        addToPair(benchmarkInfo, "Convertion to " + ((pList instanceof ArrayList) ? "LinkedList" : "ArrayList"), totalTime);

        return benchmarkInfo;
    }

    private long calculateTime(long pStart, long pEnd) {
        return pEnd - pStart;
    }

    private void addToPair(List<Pair<String, Long>> pPairList, String pActionName, long pTime) {
        pPairList.add(Pair.of(pActionName, pTime));
    }
}
