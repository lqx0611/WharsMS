package com.lqx.service;

import com.lqx.pojo.LandRepository;

import java.util.List;

/**
 * @author DUMBLEDOG
 * @date 2020/5/10 23:34
 */
public interface MatchingService {
    List<LandRepository> findAllLandRepository();

    String loadContainer(String shipNo, Integer repositoryId, Integer idMin, Integer idMax);

    String dischargeContainer(String shipNo, Integer repositoryId, Integer idMin, Integer idMax);
}
