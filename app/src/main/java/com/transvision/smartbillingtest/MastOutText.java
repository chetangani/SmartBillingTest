package com.transvision.smartbillingtest;

import android.os.Handler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;

import static com.transvision.smartbillingtest.MainActivity.DB_INSERT_SUCCESS;
import static com.transvision.smartbillingtest.MainActivity.TEXT_INSERT_SUCCESS;

class MastOutText {

    @SuppressWarnings("ResultOfMethodCallIgnored")
    void text_append(Database database, List<MastOut> mastOutList, Handler handler) {
        String path = database.filepath("Textfile");
        String filename = mastOutList.get(0).getMRCODE()+"_"+mastOutList.get(0).getREADDATE()+"_"+"INSERT_TEXT.txt";
        File log = new File(path + File.separator + filename);
        try {
            if (!log.exists()) {
                log.createNewFile();
            }
            PrintWriter out = new PrintWriter(new FileWriter(log, true));
            for (int i = 0; i < mastOutList.size(); i++) {
                out.append("insert into MAST_OUT(MONTH, READDATE, RRNO, NAME, ADD1, TARIFF, MF, PREVSTAT, AVGCON, LINEMIN, SANCHP, SANCKW, "
                        + "PRVRED, FR, IR, DLCOUNT, ARREARS, PF_FLAG, BILLFOR, MRCODE, LEGFOL, ODDEVEN, SSNO, CONSNO, PH_NO, REBATE_FLAG, "
                        + "RREBATE, EXTRA1, DATA1, EXTRA2, DATA2, DEPOSIT, MTRDIGIT, ASDAMT, IODAMT, PFVAL, BMDVAL, BILL_NO, INTEREST_AMT, "
                        + "CAP_FLAG, TOD_FLAG, TOD_PREVIOUS1, TOD_PREVIOUS3, INT_ON_DEP, SO_FEEDER_TC_POLE, TARIFF_NAME, PREV_READ_DATE, "
                        + "BILL_DAYS, MTR_SERIAL_NO, CHQ_DISSHONOUR_FLAG, CHQ_DISHONOUR_DATE, FDRNAME, TCCODE, MTR_FLAG, PRES_RDG, PRES_STS, "
                        + "UNITS, FIX, ENGCHG, REBATE_AMOUNT, TAX_AMOUNT, BMD_PENALTY, PF_PENALTY, PAYABLE, BILLDATE, BILLTIME, TOD_CURRENT1, "
                        + "TOD_CURRENT3, GOK_SUBSIDY, DEM_REVENUE, GPS_LAT, GPS_LONG, ONLINE_FLAG, BATTERY_CHARGE, SIGNAL_STRENGTH, IMGADD, "
                        + "PAYABLE_REAL, PAYABLE_PROFIT, PAYABLE_LOSS, BILL_PRINTED, FSLAB1, FSLAB2, FSLAB3, FSLAB4, FSLAB5, ESLAB1, ESLAB2, "
                        + "ESLAB3, ESLAB4, ESLAB5, ESLAB6, CHARITABLE_RBT_AMT, SOLAR_RBT_AMT, FL_RBT_AMT, HANDICAP_RBT_AMT, PL_RBT_AMT, "
                        + "IPSET_RBT_AMT, REBATEFROMCCB_AMT, TOD_CHARGES, PF_PENALITY_AMT, EXLOAD_MDPENALITY, CURR_BILL_AMOUNT, "
                        + "ROUNDING_AMOUNT, DUE_DATE, DISCONN_DATE, CREADJ, PREADKVAH, AADHAAR, MAIL, MTR_DIGIT, ELECTION, RATION, WATER, "
                        + "HOUSE_NO, VERSION, DL_FC, FDRCODE, TCNAME, RENT)"
                        + "values(" + "'")
                        .append(mastOutList.get(i).getMONTH()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getREADDATE()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getRRNO()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getNAME()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getADD1()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getTARIFF()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getMF()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getPREVSTAT()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getAVGCON()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getLINEMIN()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getSANCHP()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getSANCKW()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getPRVRED()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getFR()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getIR()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getDLCOUNT()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getARREARS()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getPFFLAG()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getBILLFOR()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getMRCODE()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getLEGFOL()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getODDEVEN()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getSSNO()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getCONSNO()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getPHNO()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getREBATEFLAG()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getRREBATE()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getEXTRA1()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getDATA1()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getEXTRA2()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getDATA2()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getDEPOSIT()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getMTRDIGIT()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getASDAMT()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getIODAMT()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getPFVAL()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getBMDVAL()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getBILLNO()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getINTERESTAMT()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getCAPFLAG()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getTODFLAG()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getTODPREVIOUS1()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getTODPREVIOUS3()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getINTONDEP()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getSOFEEDERTCPOLE()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getTARIFFNAME()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getPREVREADDATE()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getBILLDAYS()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getMTRSERIALNO()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getCHQDISSHONOURFLAG()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getCHQDISHONOURDATE()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getFDRNAME()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getTCCODE()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getMTRFLAG()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getPRESRDG()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getPRESSTS()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getUNITS()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getFIX()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getENGCHG()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getREBATEAMOUNT()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getTAXAMOUNT()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getBMDPENALTY()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getPFPENALTY()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getPAYABLE()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getBILLDATE()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getBILLTIME()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getTODCURRENT1()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getTODCURRENT3()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getGOKSUBSIDY()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getDEMREVENUE()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getGPSLAT()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getGPSLONG()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getONLINEFLAG()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getBATTERYCHARGE()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getSIGNALSTRENGTH()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getIMGADD()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getPAYABLEREAL()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getPAYABLEPROFIT()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getPAYABLELOSS()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getBILLPRINTED()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getFSLAB1()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getFSLAB2()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getFSLAB3()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getFSLAB4()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getFSLAB5()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getESLAB1()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getESLAB2()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getESLAB3()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getESLAB4()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getESLAB5()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getESLAB6()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getCHARITABLERBTAMT()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getSOLARRBTAMT()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getFLRBTAMT()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getHANDICAPRBTAMT()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getPLRBTAMT()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getIPSETRBTAMT()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getREBATEFROMCCBAMT()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getTODCHARGES()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getPFPENALITYAMT()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getEXLOADMDPENALITY()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getCURRBILLAMOUNT()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getROUNDINGAMOUNT()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getDUEDATE()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getDISCONNDATE()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getCREADJ()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getPREADKVAH()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getAADHAAR()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getMAIL()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getMTRDIGIT()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getELECTION()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getRATION()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getWATER()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getHOUSENO()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getVERSION()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getDLFC()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getFDRCODE()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getTCNAME()).append("'").append(",")
                        .append("'").append(mastOutList.get(i).getRENT()).append("'")
                        .append(")");
                out.append("\r\n");
            }
            out.close();
            handler.sendEmptyMessage(TEXT_INSERT_SUCCESS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void readFile(Database database, UpdateDatabase updateDatabase, Handler handler){
        String line;
        String path = database.filepath("Textfile");
        String filename = "INSERT_TextReport.txt";
        try {
            FileInputStream fileInputStream = new FileInputStream (new File(path + File.separator + filename));
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while ((line = bufferedReader.readLine()) != null) {
                updateDatabase.insert_data(line);
            }
            fileInputStream.close();
            bufferedReader.close();
            handler.sendEmptyMessage(DB_INSERT_SUCCESS);
        } catch(IOException ex) {
            database.logStatus(ex.getMessage());
        }
    }
}
