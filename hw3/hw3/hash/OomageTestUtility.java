package hw3.hash;

import java.util.HashMap;
import java.util.List;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /* TODO:
         * Write a utility function that returns true if the given oomages
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */

        HashMap<Integer, Integer> bucketDistribution = new HashMap<>();
        for(Oomage oomage:oomages){
            int bucketNum = (oomage.hashCode() & 0x7FFFFFFF) % M;
            if(bucketDistribution.containsKey(bucketNum)){
                int count = bucketDistribution.get(bucketNum);
                bucketDistribution.put(bucketNum, ++count);
            }else{
                bucketDistribution.put(bucketNum, 1);
            }
        }
        for(Integer bucketNum:bucketDistribution.keySet()){
            Boolean niceSpread = (bucketDistribution.get(bucketNum) <= oomages.size() / 2.5)
                    && (bucketDistribution.get(bucketNum) >= oomages.size() / 50);
            if(!niceSpread){
                return false;
            }
        }
        return true;
    }
}
