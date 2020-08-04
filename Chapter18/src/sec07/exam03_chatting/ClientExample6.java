package sec07.exam03_chatting;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientExample6 extends Application {
    Socket socket;
    
    void startClient() {
        // 연결 시작 코드
        Thread thread = new Thread(() -> {
            try {
                socket = new Socket();
                socket.connect(new InetSocketAddress("localhost", 5001));

                Platform.runLater(() -> {
                    displayText("[연결 완료: " + socket.getRemoteSocketAddress() + "]");
                    btnConn.setText("stop");
                    btnSend.setDisable(false);
                });

            } catch (IOException e) {
                Platform.runLater(() -> displayText("[서버 통신 안됨]"));
                if (!socket.isClosed()) {
                    stopClient();
                }
                return;
            }
            receive();
        });
        thread.start();
    }
    
    void stopClient() {
        // 연결 끊기 코드
        try {
            Platform.runLater(() -> {
                displayText("[연결 끊음]");
                btnConn.setText("start");
                btnSend.setDisable(true);
            });
            if (socket != null && !socket.isClosed()) socket.close();
        } catch (IOException e) {

        }
    }
    
    void receive() {
        // 데이터 받기 코드
        while (true) {
            try {
                byte[] byteArr = new byte[100];
                InputStream inputStream = socket.getInputStream();

                int readByteCount = inputStream.read(byteArr);
                if (readByteCount == -1) throw new IOException();

                String data = new String(byteArr, 0, readByteCount, StandardCharsets.UTF_8);

                Platform.runLater(() -> displayText("[받기 완료]" + data));

            } catch (IOException e) {
                Platform.runLater(() -> displayText("[서버 통신 안됨]"));
                stopClient();
                break;
            }
        }
    }
    
    void send(String data) {
        // 데이터 전송 코드
        Thread thread = new Thread(() -> {
            try {
                byte[] byteArr = data.getBytes(StandardCharsets.UTF_8);
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(byteArr);
                outputStream.flush();

                Platform.runLater(() -> displayText("[보내기 완료]"));
            } catch (IOException e) {
                Platform.runLater(() -> displayText("[서버 통신 안됨]"));
                stopClient();
            }
        });
        thread.start();
    }


    //////////////////////////////////////////////////////
    TextArea txtDisplay;
    TextField txtInput;
    Button btnConn, btnSend;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        root.setPrefSize(500, 300);

        txtDisplay = new TextArea();
        txtDisplay.setEditable(false);
        BorderPane.setMargin(txtDisplay, new Insets(0,0,2,0));
        root.setCenter(txtDisplay);

        BorderPane bottom = new BorderPane();
        txtInput = new TextField();
        txtInput.setPrefSize(60, 30);
        BorderPane.setMargin(txtInput, new Insets(0,1,1,1));

        btnConn = new Button("start");
        btnConn.setPrefSize(60, 30);
        btnConn.setOnAction(e->{
            if(btnConn.getText().equals("start")) {
                startClient();
            } else if(btnConn.getText().equals("stop")){
                stopClient();
            }
        });

        btnSend = new Button("send");
        btnSend.setPrefSize(60, 30);
        btnSend.setDisable(true);
        btnSend.setOnAction(e->send(txtInput.getText()));

        bottom.setCenter(txtInput);
        bottom.setLeft(btnConn);
        bottom.setRight(btnSend);
        root.setBottom(bottom);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("app.css").toString());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Client");
        primaryStage.setOnCloseRequest(event->stopClient());
        primaryStage.show();
    }

    void displayText(String text) {
        txtDisplay.appendText(text + "\n");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
