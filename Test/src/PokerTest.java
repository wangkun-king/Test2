
class PokerTest {

    public static void main(String[] args) {
        Poker poker = new Poker();
        poker.shuffle();                // ϴ��
        Poker.Card c1 = poker.deal(0);  // ����һ����
        // ���ڷǾ�̬�ڲ���Card
        // ֻ��ͨ�����ⲿ��Poker������ܴ���Card����
        Poker.Card c2 = poker.new Card("����", 1);    // �Լ�����һ����
        Poker.Card c3 = poker.new Card("����", 13);
        System.out.println(c1);     // ϴ�ƺ�ĵ�һ��
        System.out.println(c2);     // ��ӡ: ����A
        System.out.println(c3);     // ��ӡ: ����K
    }
}