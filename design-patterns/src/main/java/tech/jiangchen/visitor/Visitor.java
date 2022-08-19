package tech.jiangchen.visitor;

public interface Visitor {
    void visit(PdfFile pdfFile);

    void visit(PPTFile pdfFile);

    void visit(WordFile pdfFile);
}
