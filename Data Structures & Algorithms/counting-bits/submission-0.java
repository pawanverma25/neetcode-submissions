class Solution {
    public int[] countBits(int n) {
        AtomicInteger i = new AtomicInteger(0);
        int [] res = new int[n + 1];
        IntStream.range(0, n + 1).mapToObj(Integer::bitCount)
            .forEach(el -> {
                res[i.getAndIncrement()] = el;
            });
        return res;
    }
}
