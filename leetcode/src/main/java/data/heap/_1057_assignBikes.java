package data.heap;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @BelongsProject: codes
 * @BelongsPackage: data.heap
 * @Author: xuyifang
 * @CreateTime: 2021-08-10 23:01
 * @Description:
 */
public class _1057_assignBikes {

    class WorkerBike {
        int workerId;
        int bikeId;
        int distance;

        WorkerBike(int workerId, int bikeId, int distance) {
            this.workerId = workerId;
            this.bikeId = bikeId;
            this.distance = distance;
        }
    }

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int N = workers.length;     // N <= M
        int M = bikes.length;

        int[] res = new int[N];
        PriorityQueue<WorkerBike> pq = new PriorityQueue<>((a, b) -> {
            if (a.distance != b.distance) {
                return a.distance - b.distance;
            }
            if (a.workerId != b.workerId) {
                return a.workerId - b.workerId;
            }
            return a.bikeId - b.bikeId;
        });
        Set<Integer> workerSet = new HashSet<>();
        Set<Integer> bikeSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            workerSet.add(i);
        }
        for (int j = 0; j < M; j++) {
            bikeSet.add(j);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                WorkerBike wb = new WorkerBike(i, j, getDistance(workers[i], bikes[j]));
                pq.add(wb);
            }
        }

        while (workerSet.size() > 0) {
            WorkerBike wb = pq.remove();
            if (workerSet.contains(wb.workerId) && bikeSet.contains(wb.bikeId)) {
                res[wb.workerId] = wb.bikeId;
                workerSet.remove(wb.workerId);
                bikeSet.remove(wb.bikeId);
            }
        }
        return res;
    }

    private int getDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}
