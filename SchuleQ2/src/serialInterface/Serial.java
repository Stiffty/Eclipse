package serialInterface;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortInvalidPortException;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStream;

/**
*  <b>Klasse Serial: Serielle Ein-/Ausgabe</b> <br /> <br/>
*
*  <b>Windows 10 - Version 09/2020, ab JDK > Java 10</b> <br/>
*
*  Infotext (aus Serial - Version 3.0):<br/>
*
*  Ein Objekt der Klasse Serial kapselt eine serielle Schnittstelle (RS232) und 
*  damit einen seriellen Port. Festlegung der Uebertragungs-Parameter kann nur 
*  bei der Objekt-Erzeugung vorgenommen werden.<br/>
*  <br/>
*  Wenn alles gut gegangen ist, ist das Serial-Objekt danach bereit.
*  Dies kann durch den Rueckgabewert der Methode
*  {@link Serial#open open()} festgestellt werden. Diese liefert true bei 
*  bereit).<br />
*  <br />
*  Das Serial-Objekt gestattet im Zustand &quot;bereit&quot; das Lesen bzw.
*  Schreiben von einzelnen Zeichen, Bytes, Byte-Arrays oder Strings von der 
*  bzw. auf die serielle Schnittstelle.<br />
*  <br />
*  <b>Installationshinweise</b><br/>
*  <br>
*  siehe IB_BG_PI_Installationshinweise_serielle_Schnittstelle.pdf<br>
*
*  Fuer diese Version ist folgendes Paket einzubinden:
* 
*  jSerialComm.jar (Stand 31.08.2020 die Version 2.6.2)
*  
*  API: https://fazecast.github.io/jSerialComm/javadoc/com/fazecast/jSerialComm/package-summary.html
*
*  WICHTIG: Das Paket gnu.io (rxtx.jar) ist NICHT mehr notwendig.
*
*  @author  Rainer Wieland, Juergen Mang
*  @version 5.0.0 vom 31.08.2020
*/
public class Serial{

  // Anfang Attribute
  private static final boolean DEBUG_SERIAL = true; // Initiale Belegung (Testausgaben)
                                                    // auf false setzen, wenn Testausgaben
                                                    // ausgeschaltet werden sollen
  
  public static final String VERSION = "5.0.0";

  public static final int FLOW_CONTROL_DISABLED            = SerialPort.FLOW_CONTROL_DISABLED;
  public static final int FLOW_CONTROL_CTS_ENABLED         = SerialPort.FLOW_CONTROL_CTS_ENABLED;
  public static final int FLOW_CONTROL_DSR_ENABLED         = SerialPort.FLOW_CONTROL_DSR_ENABLED;
  public static final int FLOW_CONTROL_DTR_ENABLED         = SerialPort.FLOW_CONTROL_DTR_ENABLED;
  public static final int FLOW_CONTROL_RTS_ENABLED         = SerialPort.FLOW_CONTROL_RTS_ENABLED;
  public static final int FLOW_CONTROL_XONXOFF_IN_ENABLED  = SerialPort.FLOW_CONTROL_XONXOFF_IN_ENABLED;
  public static final int FLOW_CONTROL_XONXOFF_OUT_ENABLED = SerialPort.FLOW_CONTROL_XONXOFF_OUT_ENABLED;

  public static final int LISTENING_EVENT_DATA_AVAILABLE   = SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
  public static final int LISTENING_EVENT_DATA_RECEIVED    = SerialPort.LISTENING_EVENT_DATA_RECEIVED;
  public static final int LISTENING_EVENT_DATA_WRITTEN     = SerialPort.LISTENING_EVENT_DATA_WRITTEN;

  public static final int NO_PARITY                        = SerialPort.NO_PARITY;
  public static final int EVEN_PARITY                      = SerialPort.EVEN_PARITY;
  public static final int ODD_PARITY                       = SerialPort.ODD_PARITY;
  public static final int SPACE_PARITY                     = SerialPort.SPACE_PARITY;
  public static final int MARK_PARITY                      = SerialPort.MARK_PARITY;

  public static final int TIMEOUT_NONBLOCKING              = SerialPort.TIMEOUT_NONBLOCKING;
  public static final int TIMEOUT_READ_BLOCKING            = SerialPort.TIMEOUT_READ_BLOCKING;
  public static final int TIMEOUT_READ_SEMI_BLOCKING       = SerialPort.TIMEOUT_READ_SEMI_BLOCKING;
  public static final int TIMEOUT_SCANNER                  = SerialPort.TIMEOUT_SCANNER;
  public static final int TIMEOUT_WRITE_BLOCKING           = SerialPort.TIMEOUT_WRITE_BLOCKING;

  public static final int ONE_STOP_BIT                     = SerialPort.ONE_STOP_BIT;
  public static final int ONE_POINT_FIVE_STOP_BITS         = SerialPort.ONE_POINT_FIVE_STOP_BITS;
  public static final int TWO_STOP_BITS                    = SerialPort.TWO_STOP_BITS;

  private BufferedReader br   = null;
  private DataInputStream dis = null;
  private InputStream is      = null;
  private OutputStream os     = null;

  private SerialPort sp       = null;
  
  private boolean isOpen;
  
  // Attribute zur Kurzbeschreibung:
  
  private String portName;
  private int baudrate;
  private int dataBits;
  private int stopBits;
  private int parity;
  
  // Ende Attribute
  
    // KONSTRUKTOR
    /**
     * Konstruktor der Klasse Serial. Es werden alle erforderlichen Attribute 
     * dieser Klasse initialisiert.
     * 
     * Es werden automatisch die entsprechenden Streams zum Lesen und Schreiben 
     * testweise geoeffnet und wieder geschlossen.
     * 
     * @param portName Der Port der geoeffnet werden soll. Zum Beispiel COM11.
     * @param baudrate Die Übertragungsrate die verwendet werden soll. Beispiel: 9600
     * @param dataBits Wie viele Bits uebertragen werden sollen (5...8). Standard: 8.
     * @param stopBits Wie viele Stop Bits gesendet werden sollen (ONE_STOP_BIT, ONE_POINT_FIVE_STOP_BITS, TWO_STOP_BITS)
     * @param parity Welche Art von Paritaetsbits verwendet werden (NO_PARITY, EVEN_PARITY, ODD_PARITY, SPACE_PARITY, MARK_PARITY).
     */
  public Serial(String portName, int baudrate, int dataBits, int stopBits, int parity) throws Exception
  {
      this.baudrate = -1;
      this.portName = "";
      this.dataBits = -1;
      this.stopBits = -1;
      this.parity   = -1;

      if(DEBUG_SERIAL)
          System.out.println("Serial - Version " + VERSION + " used jSerialComm-Version " + com.fazecast.jSerialComm.SerialPort.getVersion() + ".\n");

      if(!isPortNameValid(portName))
          return; //throw new Exception("PortName not valid!");

      if(!isBaudRateValid(baudrate))
          return; //throw new Exception("BaudRate not valid!");

      if(!isDataBitsValid(dataBits))
          return; //throw new Exception("Databits not valid!");

      if(!isStopBitsValid(stopBits))
          return; //throw new Exception("Sopbits not valid!");

      if(!isParityValid(parity))
          return; //throw new Exception("Parity not valid!");

      try
      {
        sp = SerialPort.getCommPort(portName);
    
        this.baudrate = baudrate;
        this.portName = portName;
        this.dataBits = dataBits;
        this.stopBits = stopBits;
        this.parity   = parity;
      }
      catch (SerialPortInvalidPortException spipe)
      {
        //throw new Exception(spipe);
      }
  }
  /**
  * ***************************************************************************
  * METHODEN HESSISCHES LANDESABITUR
  * ***************************************************************************
  */  

  /**
   * oeffnet die serielle Scnittstelle. Liefert true, wenn die Schnittstelle 
   * verwndbar / geoffnet werden kann, sost false.
   * 
   * @return true, wenn die Schnittstelle geoeffnet werden konnte, sonst false.
   */
  public boolean open()
  {
    if(sp != null && !sp.isOpen() && sp.openPort())
    {
        if(sp.setBaudRate(this.baudrate))
        {
            if(DEBUG_SERIAL)
                System.out.println("Baudrate wurde auf " + this.baudrate +  " gesetzt!");
        }
        else
        {
            if(DEBUG_SERIAL)
                System.out.println("Baudrate konnte nicht auf " + this.baudrate +  " gesetzt werden!");
            return false;
        }

        if(sp.setParity(this.parity))
        {
            if(DEBUG_SERIAL)
                System.out.println("Parity wurde auf " + this.parity +  " gesetzt!");
        }
        else
        {
            if(DEBUG_SERIAL)
                System.out.println("Parity konnte nicht auf " + this.parity +  " gesetzt werden!");
            return false;
        }

        if(sp.setNumDataBits(this.dataBits))
        {
            if(DEBUG_SERIAL)
                System.out.println("Databits wurde auf " + this.dataBits +  " gesetzt!");
        }
        else
        {
            if(DEBUG_SERIAL)
                System.out.println("Databits konnte nicht auf " + this.dataBits +  " gesetzt werden!");
            return false;
        }

        if(sp.setNumStopBits(this.stopBits))
        {
            if(DEBUG_SERIAL)
                System.out.println("Stopbits wurde auf " + this.stopBits +  " gesetzt!");
        }
        else
        {
            if(DEBUG_SERIAL)
                System.out.println("Stopbits konnte nicht auf " + this.stopBits +  " gesetzt werden!");
            return false;
        }

        this.sp.setFlowControl(FLOW_CONTROL_DISABLED);
      
        // TimeOut-Konfigurationen:
        this.sp.setComPortTimeouts(TIMEOUT_READ_SEMI_BLOCKING, 1000, 1000); 
      
        this.os  = sp.getOutputStream();
        this.br  = new BufferedReader(new InputStreamReader(sp.getInputStream()));
        this.is  = this.sp.getInputStream();
        this.dis = new DataInputStream(this.is);
      
        this.isOpen = true;
        return true;
      }
      else{
        this.isOpen = false;
        return false;
      }
  }

  /**
   * schliesst die serielle Schnittstelle; die Schnittstelle ist dann 
   * nicht mehr verwendbar, bis sie wieder geoeffnet wird.
   */
  public void close()
  {
    try
    {
        this.br.close();
        this.dis.close();
        this.is.close();
        if(this.sp.isOpen()){
          
            this.sp.closePort();
            this.isOpen = false;
        }
    }
    catch(Exception e)
    {
        if(DEBUG_SERIAL)
            System.out.println("Fehler: Beim Schreiben in der Methode 'public void close()' ist ein Fehler aufgetreten\n" + e.toString());

    }
  }
  
  /**
   * liefert beim Aufruf die aktuelle Anzahl der Bytes zurueck, die beim Aufruf 
   * der Mehode von der seriellen Schnittstelle gelesen werden koennen. 
   * Die Methode ist nicht blockierend (nicht wartend).
   * 
   * @return aktuelle Anzahl der Bytes die eingelesen werden koennen.
   */
  public int dataAvailable()
  {
      try
      {
          return this.dis.available();
      }
      catch (Exception e)
      {
          if(DEBUG_SERIAL)
              System.out.println("Fehler: Beim Schreiben in der Methode 'public int dataAvailable()' ist ein Fehler aufgetreten\n" + e.toString());
          return 0;
      }
  }  
  
  /**
   * liest ein Byte (0..255) von der seriellen Schnittstelle, bzw. liefert -1 
   * zurueck, wenn die Schnittstelle nicht geoeffnet ist oder keine Daten gelesen
   * werden koennen.
   * 
   * Zu pruefen, ob das korrekt ist 
   * Die Methode blockiert, bis genau ein Byte(wert) verfuegbar ist. ???
   * 
   * @return den eingelesenen Wert oder -1, wenn nichts zum Lesen vorhanden ist.
   */
  public int read()
  {
      try
      {
          if(this.isOpen == false){
            return -1; 
          }
        
          if(dataAvailable() == 0)
              return -1;
        
          return readByte();
      }
      catch(Exception ioe)
      {
          if(DEBUG_SERIAL)
              System.out.println("Fehler: Beim Lesen in der Methode read() ist ein Fehler aufgetreten\n" + ioe.toString());
          return -1;
      }
  }
  
  /**
   * liest eine Zeile von der seriellen Schnittstelle, wenn Daten an der 
   * Schnittstelle verfuegbar sind und gibt diese als Zeichenkette zurueck. 
   * Wenn Daten verfuegbar sind, dann wird eine Zeile nur dann gelesen, wenn 
   * diese durch ein Zeilenendezeichen ("\n") abgeschlossen ist. 
   * Das Zeilenendezeichen wird nicht mit zurueckgegeben. Wenn Daten an der 
   * Schnittstelle verfuegbar sind, blockiert die Methode, bis eine komplette 
   * Zeile fertig eingelesen ist.
   * 
   * @return die eingelesene Zeile als String oder null, wenn nicht gelesen werden konnte.
   */
  public String readLine()
  {
      try
      {
          return this.br.readLine();
      }
      catch (Exception e)
      {
          if(DEBUG_SERIAL)
              System.out.println("Fehler: Beim Schreiben in der Methode 'public String readLine()' ist ein Fehler aufgetreten\n" + e.toString());
          return null;
      }
  }
  
  /**
   * schreibt ein Byte (0..255) auf die serielle Schnittstelle; wenn die 
   * Schnittstelle nicht geoeffnet ist, geschieht nichts.
   * 
   * @param value Byte welches gesendet werden soll.
   */
  public void write(int value)
  {
      try
      {
          writeByte(value);
      }
      catch (Exception ioe)
      {
          if(DEBUG_SERIAL)
              System.out.println("Fehler: Beim Schreiben in der Methode 'public void write(int value)' ist ein Fehler aufgetreten\n" + ioe.toString());
      }
  }  
  
  /**
   * schreibt einen String auf die serielle Schnittstelle; wenn die 
   * Schnittstelle nicht geoeffnet ist, geschieht nichts.
   * 
   * @param s String der gesendet werden soll.

   */
  public void write(String s)
  {
    try
    {
      this.os.write(s.getBytes());
      this.os.flush();
    }
    catch (Exception e)  
    {
      if(DEBUG_SERIAL)
        System.out.println("Fehler: Beim Schreiben in der Methode 'public void write(String s)' ist ein Fehler aufgetreten\n" + e.toString());
    }
  }  
  
    /**
     * setzt den Status des Modem-Steuerausgangs RTS (request to send) auf arg.
     * True entspricht HIGH und false LOW.
     *
     * @param arg true wenn der RTS-Pegel auf High gesetzt werden soll oder false, wenn der RTS-Pegel auf Low gesetzt werden soll.
     */
    public void setRTS(boolean arg)
    {
        try
        {
            if (arg == true)
                this.sp.setRTS();
            else
                this.sp.clearRTS();
        }
        catch (Exception e)
        {
            if(DEBUG_SERIAL)
                System.out.println("Fehler: Beim Schreiben in der Methode 'public void setRTS(boolean arg)' ist ein Fehler aufgetreten\n" + e.toString());
        }
    }

    /**
     * setzt den Status des Modem-Steuerausgangs DTR (data terminal ready) auf arg.
     * True entspricht HIGH und false LOW.
     * 
     * @param arg true wenn der DTR-Pegel auf High gesetzt werden soll oder false, wenn der DTR-Pegel auf Low gesetzt werden soll.
     */
    public void setDTR(boolean arg)
    {
      try
    {
      if (arg == true)
        this.sp.setDTR();
        
      else
        this.sp.clearDTR();
        
      }
      catch (Exception e)
      {
        if(DEBUG_SERIAL)
          System.out.println("Fehler: Beim Schreiben in der Methode 'public void setDTR(boolean arg)' ist ein Fehler aufgetreten\n" + e.toString());
      }
    }

    /**
     * liefert den Status des Modem-Steuereingangs CTS (clear to send). 
     * True wenn CTS auf High ist, sonst false.
     * 
     * @return den Wert von CTS. 
     */
    public boolean isCTS()
    {
      try
      {
        return this.sp.getCTS();
      }
      catch (Exception e)
      {
        if(DEBUG_SERIAL)
          System.out.println("Fehler: Beim Schreiben in der Methode 'public boolean isCTS()' ist ein Fehler aufgetreten\n" + e.toString());
        
        return false;
        }
    }
  
    /**
     * Diese Methode gibt den Status von der Steuerleitung DSR der seriellen Schnittstelle zurueck.
     * @return Der Wert von DSR. True wenn DSR gesetzt ist, ansonsten false.
     */
    public boolean isDSR()
    {
        try
        {
            return this.sp.getDSR();
        }
        catch (Exception e)
        {
            if(DEBUG_SERIAL)
                System.out.println("Fehler: Beim Schreiben in der Methode 'public boolean isDSR()' ist ein Fehler aufgetreten\n" + e.toString());
            return false;
        }
    }
  /**
  * ***************************************************************************
  * ENDE METHODEN HESSISCHES LANDESABITUR
  * ***************************************************************************
  */  
    
  /**
  * ***************************************************************************
  * WEITERE METHODEN ODER HILFSMETHODEN
  * ***************************************************************************
  */
  
  /**
   * Diese Methode gibt den Status der Steuerleitung RI (Ring Indicator) der seriellen Schnittstelle zurueck.
   * @return Der Wert von RI. True wenn RI gesetzt ist, ansonsten false.
   */
  public boolean getRI()
  {
      try
      {
          return this.sp.getRI();
      }
      catch (Exception e)
      {
          if(DEBUG_SERIAL)
              System.out.println("Fehler: Beim Schreiben in der Methode 'public boolean getRI()' ist ein Fehler aufgetreten\n" + e.toString());
          return false;
      }
  }

  /**
   * Diese Methode gibt den Status von der Steuerleitung DTR der seriellen Schnittstelle zurueck.
   * @return Der Wert von DTR. True wenn DTR gesetzt ist, ansonsten false.
   * <p>
   * Note that polling this line's status is not supported on Windows, so results may be incorrect.
   */
  public boolean getDTR()
  {
      try
      {
          return this.sp.getDTR();
      }
      catch (Exception e)
      {
          if(DEBUG_SERIAL)
              System.out.println("Fehler: Beim Schreiben in der Methode 'public boolean getDTR()' ist ein Fehler aufgetreten\n" + e.toString());
          return false;
      }
  }

  /**
   * Diese Methode gibt den Status von der Steuerleitung RTS der seriellen Schnittstelle zurueck.
   * @return Der Wert von RTS. True wenn RTS gesetzt ist, ansonsten false.
   */
  public boolean getRTS()
  {
      try
      {
          return this.sp.getRTS();
      }
      catch (Exception e)
      {
          if(DEBUG_SERIAL)
              System.out.println("Fehler: Beim Schreiben in der Methode 'public boolean getRTS()' ist ein Fehler aufgetreten\n" + e.toString());
          return false;
      }
  }



  /**
   * Diese Methode gibt den Status von der Steuerleitung CD (Carrier Detect) der seriellen Schnittstelle zurueck.
   * @return Der Wert von CD. True wenn CD gesetzt ist, ansonsten false.
   */
  public boolean getCD()
  {
      try
      {
          return this.sp.getDCD();
      }
      catch (Exception e)
      {
          if(DEBUG_SERIAL)
              System.out.println("Fehler: Beim Schreiben in der Methode 'public boolean getCD()' ist ein Fehler aufgetreten\n" + e.toString());
          return false;
      }
  }








  /**
   * Diese Methode sendet das uebergebene Byte Array ueber die geoeffnete serielle Schnittstelle.
   * 
   * @param b Das Byte Array was gesendet werden soll.
   * @param len Anzahl der Bytes, die gesendet werden sollen.
   * Wenn nicht gesendet werden konnte, passiert nichts
   */
  public void write(byte[] b, int len)
  {
      try
      {
          this.os.write(b, 0, len);
      }catch (Exception e)  {
          if(DEBUG_SERIAL)
              System.out.println("Fehler: Beim Schreiben in der Methode 'public void write(byte[] b, int len)' ist ein Fehler aufgetreten\n" + e.toString());}
  }

  /**
   * Diese Methode sendet den uebergebenen Byte ueber die geoeffnete serielle Schnittstelle.
   * Wenn nicht gesendet werden konnte, passiert nichts
   * 
   * @param wert das Byte das gesendet werden soll.
   */
  private void writeByte(int wert)
  {
      try
      {
          this.os.write(wert);
          this.os.flush();
      }catch (Exception e)  {
          if(DEBUG_SERIAL)
              System.out.println("Fehler: Beim Schreiben in der Methode 'private void writeByte(int wert)' ist ein Fehler aufgetreten\n" + e.toString());}
  }

  /**
   * Diese Methode sendet das übergebene Byte Array über die geöffnete serielle Schnittstelle.
   * Wenn nicht gesendet werden konnte, passiert nichts
   */
  public void writeBytes(byte[] dat)
  {
      try
      {
          this.os.write(dat);
      }catch (Exception e){
          if(DEBUG_SERIAL)
              System.out.println("Fehler: Beim Schreiben in der Methode 'private void writeBytes(byte[] dat)' ist ein Fehler aufgetreten\n" + e.toString());}

  }

  /**
   * Diese Methode liest einen Byte von der geoeffneten seriellen Schnittstelle ein.
   * Konnte nichts gelesen werden, wird -1 returniert.
   * 
   * @return den eingelesenen Wert. 
   */
  public int readByte()
  {
      try
      {
          return this.is.read();
      }catch (Exception e)
      {
          if(DEBUG_SERIAL)
              System.out.println("Fehler: Beim Schreiben in der Methode 'private int readByte()' ist ein Fehler aufgetreten\n" + e.toString());
      }
      return -1;
  }

  /**
   * liest mehrere Byte von der gefoefneten seriellen Schnittstelle ein.
   * 
   * @param length die Anzahl an Bytes die maximal gelesen werden soll.
   * Wenn weniger Bytes im Buffer sind wird ein kleineres Array zurueckgegeben.
   * @return ein Array mit den gelesenen Bytes. 
   * Konnte nichts gelesen werden, wird ein leeres byte-Array returniert.
   */
  public byte[] readBytes(int length)
  {
      try{
          byte data[] = new byte[length];
          int read = 0;
          read = this.is.read(data);
          if(read < 0){
              data = new byte[0];
          }
          else if(read < length){
              byte temp[] = data;
              data = new byte[read];
              for(int i = 0; i<read; i++){
                  data[i] = temp[i];
              }
          }
          return data;
      }
      catch(Exception e)
      {
          if(DEBUG_SERIAL)
              System.out.println("Fehler: Beim Schreiben in der Methode 'private byte[] readBytes(int length)' ist ein Fehler aufgetreten\n" + e.toString());
          return new byte[0];
      }
  }

  /**
   * liest alle im Puffer befindlichen Daten ein.
   * 
   * @return ein Array mit den gelesenen Bytes. 
   * Konnte nichts gelesen werden, wird ein leeres byte-Array returniert.
   */
  public byte[] readBytes()
  {
      try{
          return this.readBytes(this.is.available());
      }
      catch(Exception e)
      {
          if(DEBUG_SERIAL)
              System.out.println("Fehler: Beim Schreiben in der Methode 'private byte[] readBytes()' ist ein Fehler aufgetreten\n" + e.toString());
          return new byte[0];
      }

  }

  /**
   * Diese Methode liest einen Byte von der geoeffneten seriellen Schnittstelle ein.
   * 
   * Wenn die andere Methode um einen Byte einzulesen Probleme macht bzw. immer 
   * falsche Werte zurueckgibt koennte diese Methode eine Alternative sein.
   * 
   * @throws IOException Wenn nicht von der Schnittstelle gelesen werden kann.
   * Dies passiert beispielsweise immer dann, wenn diese Methode nach close aufgerufen wird.
   * @return den eingelesenen Wert.
   */
  private int readUnsignedByte() throws IOException
  {
      return this.dis.readUnsignedByte();
  }

  /**
   * Diese Methode gibt den Status des Buffered Readers zurueck. 
   * Wenn diese Methode true zurueck liefert koennen Daten eingelesen werden.
   * 
   * @throws IOException Wenn nicht von der Schnittstelle gelesen werden kann.
   * Dies passiert beispielsweise immer dann, wenn diese Methode nach close aufgerufen wird.
   * @return true wenn Daten anliegen die eingelesen werden koennen, ansonsten false.
   */
  private boolean bufferedReaderReady()
  {
      try
      {
          return this.br.ready();
      }
      catch (Exception e)
      {
          return false;
      }
  }

  public static void test(String portName) throws Exception
  {
      if(getnComPorts() == 0)
        System.out.println("Keine serielle Schnittstellen vorhanden!");
        
      Serial ssn = new Serial(portName,115200, 8, ONE_STOP_BIT, NO_PARITY);
      if(ssn.open())
      {
          while(true)
          {
              try
              {
                  if(ssn.dataAvailable() > 0)
                      System.out.println(ssn.readLine());
              }
              catch (Exception e) 
              {
              }
          }
      }

  }
  /**
  * ***************************************************************************
  * ENDE WEITERE METHODEN ODER HILFSMETHODEN
  * ***************************************************************************
  */
  
  
  /**
  * ***************************************************************************
  * HILFSMETHODEN
  * ***************************************************************************
  */
  private static int getnComPorts() {
  
      SerialPort[] sps = SerialPort.getCommPorts();
  
      int n = sps.length;

      for(int i = 0; i < n; i++){
    
          System.out.println("DescriptivePortName: " + sps[i].getDescriptivePortName());
          System.out.println("PortDescription:     " + sps[i].getPortDescription());
          System.out.println("SystemPortName:      " + sps[i].getSystemPortName());
    
      }
      return n;
  }

  private boolean isPortNameValid(String portName) {
    
      SerialPort[] sps = SerialPort.getCommPorts();

      for(int i = 0; i < sps.length; i++)
      {
          if(DEBUG_SERIAL) {
      
            System.out.println("DescriptivePortName: " + sps[i].getDescriptivePortName());
            System.out.println("PortDescription:     " + sps[i].getPortDescription());
            System.out.println("SystemPortName:      " + sps[i].getSystemPortName());
      
          }
          if(sps[i].getSystemPortName().equals(portName))
            return true;
      }
      return false;
  }

  private boolean isParityValid(int parity)
  {
      switch (parity)
      {
          case NO_PARITY:
          case EVEN_PARITY:
          case ODD_PARITY:
          case SPACE_PARITY:
          case MARK_PARITY:
          return true;
      
          default:
          return false;
      }
  }

  private boolean isStopBitsValid(int stopbits)
  {
      switch(stopbits)
      {
          case ONE_STOP_BIT:
          case ONE_POINT_FIVE_STOP_BITS:
          case TWO_STOP_BITS:
          return true;
          default:
          return false;
      }
  }

  private boolean isDataBitsValid(int databits)
  {
      if(databits >= 5 || databits <= 8)
          return true;
      return false;
  }

  private boolean isBaudRateValid(int baudrate)
  {
      return true;
  }

  /**
  * ***************************************************************************
  * ENDE HILFSMETHODEN
  * ***************************************************************************
  */
}
