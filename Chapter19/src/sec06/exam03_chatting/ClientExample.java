package sec06.exam03_chatting;

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
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ClientExample extends Application {
    SocketChannel socketChannel;

    void startClient() {
        // 연결 시작 코드
        Thread thread = new Thread(() -> {
            try {
                socketChannel = SocketChannel.open();
                socketChannel.configureBlocking(true);
                socketChannel.connect(new InetSocketAddress("localhost", 5001));

                Platform.runLater(() -> {
                    try {
                        displayText("[연결 성공]: " + socketChannel.getRemoteAddress() + "]");
                        btnConn.setText("stop");
                        btnSend.setDisable(false);
                    } catch (IOException e) {}
                });
            } catch (IOException e) {
                Platform.runLater(() -> displayText("[서버 통신 안됨]"));
                if (socketChannel.isOpen()) stopClient();
                return;
            }
            receive();
        });
        thread.start();
    }
    
    void stopClient() {
        // 연결 끊기 코드
        try {
            displayText("[연결 끊음]");
            btnConn.setText("start");
            btnSend.setDisable(true);

            if (socketChannel != null && socketChannel.isOpen()) socketChannel.close();
        } catch (IOException e) {}
    }
    
    void receive() {
        // 데이터 받기 코드
        while (true) {
            try {
                ByteBuffer byteBuffer = ByteBuffer.allocate(100);

                int readByteCount = socketChannel.read(byteBuffer);
                if (readByteCount == -1) throw new IOException();

                byteBuffer.flip();
                Charset charset = Charset.forName(String.valueOf(StandardCharsets.UTF_8));
                String data = charset.decode(byteBuffer).toString();

                Platform.runLater(() -> displayText("[받기 완료]: " + data));

            } catch (IOException e) {
                Platform.runLater(() -> displayText("[서버 통신 안됨]"));
                if (socketChannel.isOpen()) stopClient();
                break;
            }
        }
    }
    
    void send(String data) {
        // 데이터 전송 코드
        Thread thread = new Thread(() -> {
            try {
                Charset charset = Charset.forName(String.valueOf(StandardCharsets.UTF_8));
                ByteBuffer byteBuffer = charset.encode(data);

                socketChannel.write(byteBuffer);
                Platform.runLater(() -> displayText("[보내기 완료]"));
            } catch (IOException e) {
                Platform.runLater(() -> displayText("[서버 통신 안됨]"));
                if (socketChannel.isOpen()) stopClient();
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