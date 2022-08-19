package tech.jiangchen.visitor;

public class Extractor implements Visitor {
    @Override
    public void visit(PdfFile pdfFile) {
        System.out.println("Extract PDF.");
    }

    @Override
    public void visit(PPTFile pdfFile) {
        System.out.println("Extract PPT.");
    }

    @Override
    public void visit(WordFile pdfFile) {
        System.out.println("Extract WORD.");
    }
}
