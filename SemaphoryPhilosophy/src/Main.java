import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(2);
        for(int i = 1 ;i <= 4; i++)
            new Philosopher(sem, i).start();
    }
}

// ����� ��������
class Philosopher extends Thread
{
    Semaphore sem; // �������. �������������� ����� ���������
    // ���-�� ������� ����
    int num = 0;
    // �������� ����� ��������
    int id;
    // � �������� ���������� ������������ �������� ������������� �������� � �������
    Philosopher(Semaphore sem, int id)
    {
        this.sem=sem;
        this.id=id;
    }

    public void run()
    {
        try
        {
            sem.acquire();// ��������� ����������
            System.out.println ("������� " + id+" ������� �� ����");

            System.out.println ("������� " + id+" ������� ��-�� �����");
            sem.release();// ������������

            // ������� ������
            sleep(500);
        }
        catch(InterruptedException e)
        {
            System.out.println ("� �������� " + id + "   �������� �� ���������");
        }
    }
}