import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String basePath = getDownloadBase();
        String fileName = null;
        String fileType = req.getParameter("fileType");
        switch (fileType) {
            case "pdf" -> fileName = "Stress.pdf";
            case "docx" -> fileName = "Stress.docx";
            case "asm" -> fileName = "Laba1.asm";
            case "5" -> fileName = "5.docx";
            case "6" -> fileName = "6.docx";
            case "7" -> fileName = "7.docx";
        }
        File file = new File(basePath + File.separator + fileName);
//        File fileToDownload = new File();

//        File file = new File("pdf".equals(id) ? "D:/docs.pdf" : "D:/wildfly.zip");
        resp.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
        resp.setContentType("application/octet-stream"); //"application/octet-stream"
        byte[] buffer = new byte[1024 * 1024];
        try (FileInputStream stream = new FileInputStream(file)) {
            int count;
            while ((count = stream.read(buffer)) >= 0) {
                resp.getOutputStream().write(buffer, 0, count);
            }
        }
        resp.getOutputStream().close();
        req.getRequestDispatcher("upload.jsp").forward(req, resp);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        processRequest(req, resp);
    }

//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        req.getRequestDispatcher("download.jsp").forward(req, resp);
////        processRequest(req, resp);
//    }

    private String getDownloadBase() {
        return System.getProperty("download.dir");
    }
}
