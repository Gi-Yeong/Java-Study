package sec07.exam03_chatting;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerExample extends Application {
    ExecutorService executorService;
    ServerSocket serverSocket;
    List<Client> connections = new Vector<>(); // Vector 는 Thread 에서 안전함

    void startServer() {
        // 서버 시작 코드
        executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors() // CPU 가 지원하는 Core 의 수 만큼 Thread 를 생성
        );

        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("localhost", 5001));

        } catch (IOException e) {
            if (!serverSocket.isClosed()) {
                stopServer();
            }
            return;
        }

        Runnable runnable = () -> {
            Platform.runLater(() -> {
                displayText("[서버 시작]");
                btnStartStop.setText("stop");
            });

            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    String message = "[연결 수락: " + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName() + "]";
                    Platform.runLater(() -> displayText(message));

                    Client client = new Client(socket);
                    connections.add(client);
                    Platform.runLater(() -> displayText("[연결 개수: " + connections.size() + "]"));
                } catch (IOException e) {
                    if (!serverSocket.isClosed()) {
                        stopServer();
                    }
                    break;
                }
            }
        };

        executorService.submit(runnable);
    }

    void stopServer() {
        // 서버 종료 코드
        try {
            Iterator<Client> iterator = connections.listIterator();
            while (iterator.hasNext()) {
                Client client = iterator.next();
                client.socket.close();
                iterator.remove();
            }
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
            if (executorService != null && executorService.isShutdown()) {
                executorService.shutdown();
            }
            Platform.runLater(() -> {
                displayText("[서버 멈춤]");
                btnStartStop.setText("start");
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class Client {
        // 데이터 통신 코드
        Socket socket;

        public Client(Socket socket) {
            this.socket = socket;
            receive();
        }

        void receive() {
            Runnable runnable = () -> {
                try {
                    while (true) {
                        byte[] byteArr = new byte[100];
                        InputStream inputStream = socket.getInputStream();

                        int readByteCount = inputStream.read(byteArr);
                        if (readByteCount == -1) {
                            inputStream.close();
                            throw new IOException();
                        }

                        String message = "[요청 처리: " + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName() + "]";
                        Platform.runLater(() -> displayText(message));

                        String data = new String(byteArr, 0, readByteCount, StandardCharsets.UTF_8);

                        for (Client client : connections) {
                            client.send(data);
                        }


                    }
                } catch (IOException e) {
                    try {
                        connections.remove(Client.this);
                        String message = "[클라이언트 통신 안됨: " + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName() + "]";
                        Platform.runLater(() -> displayText(message));
                        socket.close();
                    } catch (IOException ioException) {}
                }
            };
            executorService.submit(runnable);
        }

        void send(String data) {
            Runnable runnable = () -> {
                try {
                    byte[] byteArr = data.getBytes(StandardCharsets.UTF_8);
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write(byteArr);
                    outputStream.flush();

                } catch (IOException e) {
                    try {
                        String message = "[클라이언트 통신 안됨: " + socket.getRemoteSocketAddress() + ": " + Thread.currentThread().getName() + "]";
                        Platform.runLater(() -> displayText(message));
                        connections.remove(Client.this);
                        socket.close();
                    } catch (IOException ioException) {}
                }

            };
            executorService.submit(runnable);
        }
    }


    //////////////////////////////////////////////////////
    TextArea txtDisplay;
    Button btnStartStop;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        root.setPrefSize(500, 300);

        txtDisplay = new TextArea();
        txtDisplay.setEditable(false);
        BorderPane.setMargin(txtDisplay, new Insets(0, 0, 2, 0));
        root.setCenter(txtDisplay);

        btnStartStop = new Button("start");
        btnStartStop.setPrefHeight(30);
        btnStartStop.setMaxWidth(Double.MAX_VALUE);
        btnStartStop.setOnAction(e -> {
            if (btnStartStop.getText().equals("start")) {
                startServer();
            } else if (btnStartStop.getText().equals("stop")) {
                stopServer();
            }
        });
        root.setBottom(btnStartStop);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("app.css").toString());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Server");
        primaryStage.setOnCloseRequest(event -> stopServer());
        primaryStage.show();
    }

    void displayText(String text) {
        txtDisplay.appendText(text + "\n");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
