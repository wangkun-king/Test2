import java.util.Comparator;

/**
 * �������ӿ�(����ģʽ: ���㷨��װ�����й�ͬ�ӿڵĶ���������ʹ�����ǿ����໥�滻)
 * @author���
 *
 */
public interface Sorter {

   /**
    * ����
    * @param list �����������
    */
   public <T extends Comparable<T>> void sort(T[] list);

   /**
    * ����
    * @param list �����������
    * @param comp �Ƚ���������ıȽ���
    */
   public <T> void sort(T[] list, Comparator<T> comp);
}