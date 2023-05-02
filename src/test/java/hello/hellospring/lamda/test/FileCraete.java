package hello.hellospring.lamda.test;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;

public class FileCraete {
    String SND_FILE_PATH = "D://file/";

    @Test
    public void createFile() {
        File file = null;
        FileWriter fw = null;

//        String fileName = "TVPS_2020319";
        String fileName = "TVPR_2020319";

        try
        {
            file 	= new File(SND_FILE_PATH + fileName);
            fw 		= new FileWriter(file, true);

//            fw.write(crateSendFileData());
            fw.write(crateRecvFileData());
            fw.close();
        }
        catch (Exception ex)
        {
            System.out.println("파일 쓰기 실패||쓰기경로:" + SND_FILE_PATH + "||파일명:" + fileName + "||" + ex.getMessage());
            ex.printStackTrace();
        }
        finally
        {
            fileName 	= null;
            file 		= null;
            fw 			= null;
        }
    }

    public String crateSendFileData() {
        StringBuffer fileSB = new StringBuffer();

        try {
            fileSB.append(createHeaderRecord());
            fileSB.append(createDataRecord());
            fileSB.append(createTrailerRecord());

            return fileSB.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String crateRecvFileData() {
        StringBuffer fileSB = new StringBuffer();

        try {
            fileSB.append(createHeaderRecord());
            fileSB.append(createResultDataRecord());
            fileSB.append(createTrailerRecord());

            return fileSB.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String createHeaderRecord()
    {
        StringBuffer startRecord = new StringBuffer();

        try
        {
            /* start record 항목 입력 */
            startRecord.append("HD");
            startRecord.append("20230319");
            startRecord.append(String.format("%-20s", "JEJUAIR001"));
            startRecord.append(String.format("%-20s", "JEJUTVHUB001"));
            startRecord.append(String.format("%-70s", ""));

            return startRecord.toString();
        }
        finally
        {
            startRecord = null;
        }
    }

    public String createDataRecord()
    {
        StringBuffer dataRecord = new StringBuffer();

        try
        {
            /* start record 항목 입력 */
            dataRecord.append("DT");
            dataRecord.append("00");
            dataRecord.append(String.format("%-8s", "20230319"));
            dataRecord.append(String.format("%-8s", "000000"));
            dataRecord.append(String.format("%-8s", "32000"));
            dataRecord.append(String.format("%-30s", "20230319135602123456"));
            dataRecord.append(String.format("%-19s", "2023031913560512345"));
            dataRecord.append(String.format("%-23s", ""));

            return dataRecord.toString();
        }
        finally
        {
            dataRecord = null;
        }
    }

    public String createResultDataRecord()
    {
        StringBuffer dataRecord = new StringBuffer();

        try
        {
            /* start record 항목 입력 */
            dataRecord.append("DT");
            dataRecord.append("00");
            dataRecord.append(String.format("%-8s", "20230319"));
            dataRecord.append(String.format("%-8s", "000000"));
            dataRecord.append(String.format("%-8s", "32000"));
            dataRecord.append(String.format("%-30s", "20230319135602123456"));
            dataRecord.append(String.format("%-19s", "2023031913560512345"));
            dataRecord.append(String.format("%-4s", "0000"));
            dataRecord.append(String.format("%-19s", ""));

            return dataRecord.toString();
        }
        finally
        {
            dataRecord = null;
        }
    }

    public String createTrailerRecord()
    {
        StringBuffer trailerRecord = new StringBuffer();

        try
        {
            /* start record 항목 입력 */
            trailerRecord.append("TR");
            trailerRecord.append(String.format("%-8s", "00000213"));
            trailerRecord.append(String.format("%-10s", "0021605400"));
            trailerRecord.append(String.format("%-8s", "00000008"));
            trailerRecord.append(String.format("%-10s", "0000010400"));
            trailerRecord.append(String.format("%-62s", ""));


            return trailerRecord.toString();
        }
        finally
        {
            trailerRecord = null;
        }
    }
}
