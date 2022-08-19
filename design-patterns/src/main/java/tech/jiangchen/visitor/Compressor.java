package tech.jiangchen.visitor;

public class Compressor implements Visitor {
    @Override
    public void visit(PdfFile pdfFile) {
        System.out.println("Compress PDF.");
    }

    @Override
    public void visit(PPTFile pdfFile) {
        System.out.println("Compress PPT.");
    }

    @Override
    public void visit(WordFile pdfFile) {
        System.out.println("Compress WORD.");
    }
}
