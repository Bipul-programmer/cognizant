public class DocumentFactoryTest {
    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document word = wordFactory.openNewDocument();
        word.save();

        System.out.println();

        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdf = pdfFactory.openNewDocument();
        pdf.save();

        System.out.println();

        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excel = excelFactory.openNewDocument();
        excel.save();
    }
}
