package com.example.convert_toriai_from_pdf_to_excel.model;

public class CsvFile {
    private String name;

    private String kouSyuName;

    private int kouzaiChouGoukei;
    private int seiHinChouGoukei;

    public String getKouSyuName() {
        return kouSyuName;
    }

    public void setKouSyuName(String kouSyuName) {
        this.kouSyuName = kouSyuName;
    }

    public CsvFile(String name, String kouSyuName, int kouzaiChouGoukei, int seiHinChouGoukei) {
        this.name = name;
        this.kouSyuName = kouSyuName;
        this.kouzaiChouGoukei = kouzaiChouGoukei;
        this.seiHinChouGoukei = seiHinChouGoukei;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKouzaiChouGoukei() {
        return kouzaiChouGoukei;
    }

    public int getSeiHinChouGoukei() {
        return seiHinChouGoukei;
    }

    @Override
    public String toString() {
        return name;
    }
}
