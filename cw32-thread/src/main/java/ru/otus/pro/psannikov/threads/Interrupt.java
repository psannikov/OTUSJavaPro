package ru.otus.pro.psannikov.threads;

public class Interrupt {
    public static void main(String[] args) throws InterruptedException {
/*Способ 1:
У любого потока внутри есть "флажок", который можно взвести снаружи потока для преостановки потока.
При этом внутри потока необходимо предусмотреть проверку состояния этого флажка,
и остановку потока (окончание метода run()), когда данный "флажок" оказался взведен снаружи.*/
        interruptDemo1();
/*Способ2:
Если поток находится в состоянии ожидания, и в этот момент снаружи кто-то взведет "флажок"
вызовом метода interrupt(), то поток завершится аварийно с выбросом исключения*/
        interruptDemo2();
    }

    private static void interruptDemo1() throws InterruptedException {
        Thread t0 = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " выполняется");
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + " завершаем");
                    return;
                }
            }
        });
        t0.start();

        Thread.sleep(4);

        t0.interrupt();
    }

    private static void interruptDemo2() throws InterruptedException {
        Thread t0 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " засыпает");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " завершается аварийно");
            }
        });
        t0.start();

        Thread.sleep(1000);

        t0.interrupt();
    }
}
