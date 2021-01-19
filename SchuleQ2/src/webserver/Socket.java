
package webserver;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
/**
 * <b>Ein-/Ausgabe über Sockets</b>. <br />
 *  Ein Objekt der Klasse Socket kapselt eine Socket-Schnittstelle. 
 *  Festlegung der Socket-Parameter kann nur bei der Objekt-Erzeugung 
 *  vorgenommen werden.<br />
 *  <br />
 *  Das Socket-Objekt kann sich mit einem Server-Socket verbinden. 
 *  Ob die Verbindungsanforderung erfolgreich war, kann durch den Rückgabewert
 *  der Methode {@link Socket#connect connect()} festgestellt werden (true, wenn
 *  die Verbindung akzeptiert wurde).<br />
 *  <br />
 *  Das Socket-Objekt gestattet im Zustand &quot;verbunden&quot; das Lesen bzw.
 *  Schreiben von einzelnen Bytes, Byte-Arrays oder Strings von der bzw. auf 
 *  die Socket-Schnittstelle.<br />
 *  <br />
 *  Copyright 2006, Michael Zimmer<br /> 
 *  <br />
 *
 *  Version 2.0:
 *  - "package socketio;" auf der Kopfzeile entfernt
 *  - Attributnamen an die Landesabiturklasse angepasst
 * 
 *  @author   Michael Zimmer, Juergen Mang
 *  @version  2.0, 21.04.2015
 *  @see ServerSocket
 */
public class Socket {
  /** Der Hosname des Servers. */
  private String remoteHostIP;
  
  /** Der Port, auf dem der Server-Socket horcht. */
  private int remotePort;
  
  /** Der Socket. */
  private java.net.Socket socket;
  
  /** Ein BufferdReader zum Lesen von Strings */
  private BufferedReader reader;
  
  /** Konstruktor. <br />
   *  <br />
   *  Erzeugt einen neuen Socket mit der angegebenen Portnummer zu dem
   *  angegebenen Host.
   *  <br />
   *  @param hostname der Hostname des Servers 
   *  @param port der Port, auf dem der Server horcht
   *  @throws IOException
   */
  public Socket(String remoteHostIP, int remotePort) throws IOException {
    this.remoteHostIP = remoteHostIP;
    this.remotePort = remotePort;
  }
  
  /** Konstruktor. <br />
   *  <br />
   *  Erzeugt einen neuen Socket mit der angegebenen Socket.
   *  Wird vom ServerSocket benutzt.
   *  <br />
   *  @param socket der Socket, mit dem das Socket-Objekt arbeiten soll
   *  @throws IOException
   */
  public Socket(java.net.Socket socket) throws IOException {
    this.socket = socket;
    this.remotePort = socket.getPort();
    this.remoteHostIP = socket.getRemoteSocketAddress().toString();
    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
  }
  
  /** Verbindet das Socket-Objekt zu der entsprechenden 
   *  Portnummer auf dem entsprechenden Host.  <br />
   *  <br />
   *  Ging alles gut, ist das Socket-Objekt verbunden.
   *  <br />
   *  @return  true, wenn die Verbindung akzeptiert wurde
   */ 
  public boolean connect() {
    try {
      socket = new java.net.Socket(remoteHostIP, remotePort);
      reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
    catch (Exception e) {
      return false;     
    }
    return true;
  }
  
//  --- Implementierung Leseoperationen ------------------------------

  /** Prüfen, ob Daten verfügbar sind. <br />
   *  <br />
   *  Liefert die Anzahl der Bytes, die vom Socket gelesen werden können,
   *  ohne beim nächsten Aufruf von read() zu blockieren.<br />
   *  <br />
   *  @return Anzahl der verfügbaren Bytes
   *  @throws IOException
   */
  public int dataAvailable() throws IOException {
    return socket.getInputStream().available();
  }
  
  /** Lesen eines Zeichens vom Socket. <br />
   *  <br />
   *  Das Zeichen wird als int im Bereich zwischen 0 bis 255 geliefert.
   *  Die Methode blockiert, bis Eingabe-Daten verfügbar sind. 
   *  Im Fehlerfall liefert sie -1 oder erzeugt eine Ausnahme. <br />
   *  <br />
   *  @return Das gelesene Byte (0..255) oder -1
   *  @throws IOException
   */
  public int read() throws IOException {
    return socket.getInputStream().read();
  }
  
  /** Lesen von Bytes vom Socket. <br />
   *  <br />
   *  Die Methode blockiert, bis Eingabe-Daten verfügbar sind. 
   *  Im Fehlerfall liefert sie -1 oder erzeugt eine Ausnahme. <br />
   *  <br />
   *  @return Die Anzahl der gelesenen Bytes oder -1
   *  @param b Der Buffer
   *  @param len Maximale Anzahl der zu lesenden Bytes
   */
  public int read(byte[] b, int len) throws IOException {
    return socket.getInputStream().read(b, 0, len);
  }
  
  /** Lesen eines Strings vom Socket. <br />
   *  <br />
   *  Die Methode liest eine Zeile, die durch ein Zeilenendezeichen 
   *  ('\n' linefeed) abgeschlossen sein muss. Der zurückgegebene 
   *  String enthält die Zeile ohne Zeilenendezeichen.
   *  Die Methode blockiert, bis Eingabe-Daten verfügbar sind. 
   *  Im Fehlerfall liefert sie -1 oder erzeugt eine Ausnahme. <br />
   *  <br />
   *  <br />
   *  @return Der String oder null
   *  @throws IOException
   */
  public String readLine() throws IOException {
    return reader.readLine();
  }

  //  --- Implementierung Schreiboperationen ---------------------------

  /** Schreiben eines Zeichens auf den Socket. <br />
   *  <br />
   *  Diese Methode schreibt ein Byte (die niederwertigen 8 Bit des
   *  Parameters b) auf den Socket.
   *  <br />
   *  @param b Das zu schreibende Byte (0..255)
   */
  public void write(int value) throws IOException {
    socket.getOutputStream().write(value);
  }
  
   /** Schreiben von Bytes auf den Socket. <br />
   *  <br />
   *  Diese Methode schreibt mehrere Bytes auf den Socket.
   *  <br />
   *  @param b Der Buffer
   *  @param len Maximale Anzahl der zu schreibenden Bytes
   *  @throws IOException
   */
  public void write(byte[] b, int len) throws IOException {
    socket.getOutputStream().write(b, 0, len);
  }
  
  /** Schreiben eines String auf den Socket. <br />
   *  <br />
   *  Diese Methode schreibt einen String zeichenweise auf den Socket.
   *  <br />
   *  @param s Der String
   *  @throws IOException
   */
  public void write(String s) throws IOException {
    socket.getOutputStream().write(s.getBytes());
  }
  
  /** Schließt den Socket.  <br />
   *  Nach dem Schließen des Socket ist das Socket-Objekt
   *  nicht mehr verbunden.<br />
   *  @throws IOException
   */
  public void close() throws IOException {
    reader.close();
    socket.close();
  }
}