public class Liweiwei {

    /**
     * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
     *
     * 3、ArrayList 是 Java 中的动态数组，Java 建议我们如果一开始就知道这个集合里需要保存元素的大小，可以在初始化的时候直接传入。
     *
     * 在 res 变量初始化的时候，最好传入 len 的阶乘，让 ArrayList 在代码执行的过程中不发生扩容行为。同理，在 path 变量初始化的时候，最好传入 len，这个路径变量最长也就到 len 为止。
     *
     *
     *
     * path 变量我们发现只是对它的末尾位置进行增加和删除的操作，显然它是一个栈，因此，使用栈语义会更清晰。但同时 Stack 这个类的文档我们，由于一些设计上的问题，建议我们使用：
     *
     * Java
     * Deque<Integer> stack = new ArrayDeque<Integer>();
     * 这一点让我很奔溃，Deque 是双端队列，它提供了更灵活的接口，同时破坏了语义，一不小心，如果用错了接口，就会导致程序错误。我采用的做法是接受官方的建议，但是在程序变量命名和使用的接口时让语义清晰：
     *
     * 这里 path 我需要表示它是从根结点到叶子结点的路径，我认为这个语义更重要，因此不改名为 stack。而在末尾添加元素和删除元素的时候，分别使用 addLast() 和 removeLast() 方法这两个最直接的方法强调只在 path 变量的末尾操作。
     *
     *
     * 最后，由于回溯算法的时间复杂度很高，因此，如果在遍历的时候，如果能够提前知道这一条分支不能搜索到满意的结果，就可以提前结束，这一步操作称之为剪枝。
     *
     * 回溯算法会大量应用“剪枝”技巧达到以加快搜索速度。有些时候，需要做一些预处理工作（例如排序）才能达到剪枝的目的。预处理工作虽然也消耗时间，但一般而且能够剪枝节约的时间更多。还有正是因为回溯问题本身时间复杂度就很高，所以能用空间换时间就尽量使用空间。否则时间消耗又上去了。
     *
     * https://pic.leetcode-cn.com/6a464ba95a7ad1c247aa39610535984c241e6b95148f8bc36b02908a190b1d54-image.png
     *
     *
     * @vasthan 这个问题我听到的说法是： Stack 类继承了 Vector 类里的一些方法，可能导致线程不安全，所以官方不推荐（这个说法仅供参考），下面是我查到的官方文档的说明，供您参考。
     *
     * 官方文档的 Deque 里是这样描述的：
     *
     * Deques can also be used as LIFO (Last-In-First-Out) stacks. This interface should be used in preference to the legacy Stack class.
     *
     * 机器翻译：双端队列也可以用作LIFO（后进先出）栈。此接口应优先于旧 Stack 类使用。
     *
     * 在 Stack 类的文档里，是这样描述的：
     *
     * A more complete and consistent set of LIFO stack operations is provided by the Deque interface and its implementations, which should be used in preference to this class. For example:
     *
     * Deque<Integer> stack = new ArrayDeque<Integer>();
     * 机器翻译：Deque 接口及其实现提供了一组更完整和一致的 LIFO 栈操作，应优先于此类使用。
     *
     *
     *
     */
}
