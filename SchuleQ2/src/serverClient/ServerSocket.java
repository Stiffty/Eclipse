package serverClient;
import java.io.IOException;
/**
 * <b>Ein-/Ausgabe über Sockets</b>. <br />
 *  Ein Objekt der Klasse ServerSocket kapselt einen Server-Socket. 
 *  Festlegung der ServerSocket-Parameter kann nur bei der Objekt-Erzeugung 
 *  vorgenommen werden.<br />
 *  <br />
 *  Das ServerSocket-Objekt kann Verbindungsanforderungen von Socket-Objekten
 *  entgegennehmen.<br /> 
 *  Ob die Verbindungsanforderung erfolgreich war, kann durch den Rückgabewert
 *  der Methode {@link ServerSocket#accept accept()} festgestellt werden. Diese
 *  liefert ein Socket-Objekt (Arbeitssocket), wenn  die Verbindung akzeptiert
 *  wurde).<br />
 *  <br />
 *  Das ServerSocket-Objekt ermöglicht nach seiner Erzeugung nur das Entgegennehmen
 *  von Verbindungsanforderungen.<br />
 *  <br />
 *  Copyright 2006, Michael Zimmer<br /> 
 *  <br />
 *
 *  Version 2.0:
 *  - "package socketio;" auf der Kopfzeile entfernt
 * 
 *  @author   Michael Zimmer, Juergen Mang
 *  @version  2.0, 21.04.2015
 *  @see Socket
 */
public class ServerSocket {

  /** Der Port, auf dem der ServerSocket horcht. */
  @SuppressWarnings("unused")
  private int localPort;
  
  /** Der ServerSocket */
  private java.net.ServerSocket serverSocket;

  /** Konstruktor. <br />
   *  <br />
   *  Erzeugt einen neuen ServerSocket mit der angegebenen Portnummer.
   *  <br />
   *  @param localPort der Port, auf dem der Server horcht
   *  @throws IOException
   */
  public ServerSocket(int localPort) throws IOException {
    this.localPort = localPort;
    serverSocket = new java.net.ServerSocket(localPort);
  }
  /** Warten auf eine Verbindungsanforderung.  <br />
   *  <br />
   *  Der Server-Socket wartet in der Methode (blockierend) auf 
   *  eingehende Client-Verbindungen.
   *  <br />
   *  @return  Socket wenn die Verbindung akzeptiert wurde, sonst null
   *  @throws IOException
   */   
  public Socket accept() throws IOException {
    return new Socket(serverSocket.accept());
  }
  /** Schließen des ServerSockets.  <br />
   *  Nach dem Schließen des ServerSocket kann der Server nicht mehr auf
   *  Verbindungsanforderungen reagieren.<br />
   *  @throws IOException
   */
  public void close() throws IOException {
    serverSocket.close();
  }
}