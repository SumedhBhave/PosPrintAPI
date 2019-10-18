package com.api;

public class PrintRequest {
    private String printContent;
    private String printerName;
    private String filePath;
    private String file;
    private String paperCutCommand;

    String getPaperCutCommand() {
        return paperCutCommand;
    }

    public void setPaperCutCommand(String paperCutCommand) {
        this.paperCutCommand = paperCutCommand;
    }

    String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    String getPrinterName() {
        return printerName;
    }

    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }

    String getPrintContent() {
        return printContent;
    }

    public void setPrintContent(String printContent) {
        this.printContent = printContent;
    }
}
