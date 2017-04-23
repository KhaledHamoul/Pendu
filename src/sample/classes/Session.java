package sample.classes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * Created by khaled Hamoul on 17/04/2017.
 */
public class Session {

    private InfoMot motsCaches[] = new InfoMot[100];
    private int nbrMotsCaches = 0 ;
    private int nbrEssaiRestant;

    private void genererCases(){

        String chaine = new String();
        try {
            InputStream ips = new FileInputStream("Mots.txt");
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            char crctr;
            int c,cpt = 1;
            StringBuffer str = new StringBuffer();


            while ((c = br.read()) != -1) {
                crctr = (char) c;
                //System.out.print(crctr);

                if ((crctr == '$')||(crctr == '\n')) {
                    switch(cpt) {

                        case (1): {
                            motsCaches[nbrMotsCaches].typeQuestion = str.toString();
                            break;
                        }
                        case (2):{
                            motsCaches[nbrMotsCaches].indecation = str.toString();
                            break;
                        }
                        case (3):{
                            motsCaches[nbrMotsCaches].reponse = str.toString();
                            nbrMotsCaches++;
                            cpt = 1;
                            break;
                        }
                    }
                    cpt++;

                }else str.append(crctr);



            }


        } catch (Exception e) {

        }
    }
    }


