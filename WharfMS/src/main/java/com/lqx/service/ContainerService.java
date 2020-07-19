package com.lqx.service;

//import com.lqx.pojo.Container;

//import com.lqx.pojo.Container;

import com.lqx.pojo.Container;

/**
 * @author DUMBLEDOG
 * @date 2020/5/8 0:05
 */
public interface ContainerService {
    //    {1}增   ===> 增加货柜  ---> 类型对船型
    void addContainer(Container container);
    //    {2}删   ===> 删除货柜
    void delContainerById();
    //    {3}改   ===> 修改货柜    //暂时不做，货柜规格好像也没办法改
    //    {4}查   ===> 查询货柜  ---> 在哪(船还是仓库)、类型、大小
    Container selectContainerById(int id);
    //    {5}码放 ===> 陆地仓库
    String putToRepository(Container container,int repositoryId,int count);
    //    {5}码放 ===> 船体仓库
    void putToShip(Container container,int shipNo);
    //    {6} 显示货柜信息
    String showContaineList(Integer pageNum,Integer pageSize,Integer repositoryID);
}
