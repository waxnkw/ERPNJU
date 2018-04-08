#xx灯具企业管理系统软件详细设计描述文档  
##1、引言  
###1.1、编制目的  
本报告详细完成xx灯具企业管理系统软件的详细设计，打到知道开发的目的，同时实现和测试人员及用户的沟通。  
本报告面向开发人员、测试人员及最终用户而编写，是了解系统的导航。
###1.2、词汇表  
无  
###1.3、参考资料  
·《软件开发的技术基础》（软件工程与计算（卷二））  
·连锁商店管理系统（MSCS）软件详细设计描述文档  
##2、产品概述  
参考xx灯具企业管理系统软件用例文档与参考xx灯具企业管理系统软件需求规格文档对产品的概述描述。  
##3、体系结构设计概述  
参考xx灯具企业管理系统软件体系结构描述文档  
##4、结构视角  
###4.1、业务逻辑层的分解  
####4.1.1、commodityBl模块  
（1）模块概述  

commodityBl模块承担的需求参见需求规格说明文档功能需求及非相关非功能需求。    

commodityBl模块的职责及接口参见软件体系结构描述文档。  

（2）整体结构  
根据体系结构的设计，我们将系统分为展示层、业务逻辑层、数据层、每一层之间为了增加灵活性和可修改性，我们会添加接口。在展示层和业务逻辑层之间，我们添加GoodsClassificationService、AddGoodsService、DeleteGoodsService、GoodsInforBlService、StockCheckService、InventoryCheckService、ActualInventoryCheckService、SaveBillService接口。业务逻辑层和数据层之间添加GoodsClassificationDataService、GoodsDataService、StockInOutRecordService。为了隔离业务逻辑职责和逻辑控制职责，我们增加了GoodsClassificationBlController、AddGoodsBlController、DeleteGoodsBlController、GoodsInforBlController、StockCheckBlController、InventoryCheckBlController、ActualInventoryCheckBlController、SaveBillBlController。GoodsClassificationBlController会将对商品分类管理的复杂业务逻辑委托给ClassificationTree、UpdateClassificationStructure、UpdateClassificationOfGoods、ID对象。AddGoodsBlController会将增加商品的复杂业务逻辑委托给ID、UpdateClassificationOfGoods、UpdateGoodsAfterStock对象。DeleteGoodsBlController会将减少商品的复杂业务逻辑委托给UpdateClassificationOfGoods、UpdateGoodsAfterStock、WarningValue对象。GoodsInforBlController会将商品信息管理的复杂业务逻辑委托给UpdateClassificationOfGoods对象。StockCheckBlController和InventoryCheckBlController会将库存审查和库存盘点的复杂业务逻辑委托给CheckSheet对象。GoodsClassificationPO、GoodsPO、StockInOutPO是作为类别、商品、出入库情况的持久化对象被添加到设计模型中去。GoodsClassificationVO、GoodsVO、StockInOutVO、ClassificationTreeVO、StockCheckSheetVO、InventroyCheckSheetVO、InventoryWarningBillVO、InventoryLossBillVO、InventoryOverVO是分别作为携带类别、商品、出入库情况、类别树、库存审查表、库存盘点表、库存报警、报损、报溢单信息的有价值对象被添加到设计模型中去的。  

commodityBl模块的设计如图4.1.1(2)-1
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/详细设计%20仓库管理员%20设计类图%20顺序图%20状态图/仓库管理员+设计类图.png)
所示。  
commodityBl模块各个类的职责如下表所示。  

|模块|职责|
| :--- | :--- |
|GoodsClassificationBlController|负责实现对应于仓库分类管理界面所需要的服务|
|ClassificationTree|负责获取类别树|
|UpdateClassificationStructure|商品类别增删改之后更新相关类别数据|
|UpdateClassificationOfGoods|完成对商品类别的修改，包括商品信息的修改，和类别信息的修改|
|ID|负责生成新的类别或者商品的ID|
|AddGoodsBlController|负责实现对应于商品增加（入库）界面所需要的服务|
|DeleteGoodsBlController|负责实现对应于商品减少（出库）界面所需要的服务|
|WarningValue|负责获取某商品的警戒值|
|UpdateGoodsAfterStock|负责商品出入库后对商品信息的修改|
|UpdateGoodsAmount|负责出入库后相关商品数据的更新|
|GoodsInforBlController|负责实现对应于商品信息管理（即查看或修改商品信息）界面所需要的服务|
|StockCheckBlController|负责实现对应于库存审查界面所需要的服务|
|InventoryCheckBlController|负责实现对应于库存盘点界面所需要的服务|
|CheckSheet|负责获取库存查看和库存盘点需要的信息|
|ActualInventoryCheckBlController|负责实现对应于实际商品库存确认界面所需要的服务|


（3）模块内部类的接口规范    


GoodsClassificationBlController的接口规范   

|提供的服务（供接口）||
| :--- | :--- |
|**GoodsClassificationBlController.getClassificationTree**||
|语法|public ClassificationTreeVO getClassificationTree() throws RemoteException; |
|前置条件|启动一个库存分类管理回合或者商品信息管理回合|
|后置条件|返回商品类别树|
|**GoodsClassifcationBlController.ifClassificationExist**||
|语法|public boolean ifClassificationExist(String classificationTag) throws RemoteException; |
|前置条件|classificationTag符合商品类别标识格式|
|后置条件|返回该类别是否存在的boolean值|
|**GoodsClassifcationBlController.addNewClassification**||
|语法|public boolean addNewClassification（**ClassificationVO classification**）throws RemoteException;|
|前置条件|启动一个增加新类别回合|
|后置条件|自动生成一个新编号，存储新类别信息，更新类别数据，返回增加成功的boolean|
|**GoodsClassifcationBlController.classificationInfor**||
|语法|public ClassificationVO classificationInfor(String classificationID) throws RemoteException;|
|前置条件|启动一个类别信息查看回合|
|后置条件|返回类别信息|
|**GoodsClassifcationBlController.addClassification**||
|语法|public boolean addClassification(**ClassificationVO classification**) throws RemoteException;|
|前置条件|启动一个增界子类别回合|
|后置条件|自动生成一个新编号，存储新类别信息，更新类别数据，返回增加成功的boolean|
|**GoodsClassifcationBlController.deleteClassification**||
|语法|public boolean deleteClassification(**ClassificationVO classification**) throws RemoteException;|
|前置条件|启动一个删除类别回合|
|后置条件|删除该类别，更新类别数据，返回删除成功的boolean|
|**GoodsClassifcationBlController.modifyClassificationOfGoods**||
|语法|public boolean modifyClassificationOfGoods(GoodsVO vo) throws RemoteException;|
|前置条件|启动一个修改所属类别回合|
|后置条件|修改该类别所属类别，更新类别数据，返回修改成功的bool|
|**GoodsClassifcationBlController.modifyClassificationInfor**||
|语法|public boolean modifyClassificationInfor(ClassificationVO vo) throws RemoteException;|
|前置条件|开启一个修改类别信息回合|
|后置条件|修改该类别信息，更新类别数据，返回修改成功的boolean|


|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
|ClassicationTree.getTree()|获得类别树对象|
|ID.rootClassificationID();|生成没有父类的新类别的ID|
|ID.sonClassificationID(String fatherClassification);|生成存在父类的新类别的ID|
|UpdateClassificationOfGoods.updateClassificationOfGoods(GoodsVO goods);|实现对商品类别的修改，包括商品信息的修改，和类别信息的修改|
|UpdateClassificationStructure.addSon(ClassificationVO classification)|在父类别下添加某子类别|
|UpdateClassificationStructure.deleteSon(ClassificationVO classification)|在父类别下删除某子类别|
|commodityDataService.GoodsClassificationDataService.find(String calssificationTag)|获得某类别信息|
|commodityDataService.GoodsClassificationDataService.insert(SlassificationPO po)|插入一个类别|
|commodityDataService.GoodsClassificationDataService.delete(ClassificationPO po)|删除一个类别|
|commodityDataService.GoodsClassificationDataService.update(ClassificationPO po)|更新一个类别|


ClassicationTree的接口规范  

|提供的服务（供接口）||
| :--- | :--- |
|**ClassicationTree.setTreeLayerAndConnection**||
|语法|public ClassificationTreeVO setTreeLayerAndConnection(ClassificationTreeVO tree); |
|前置条件|存在一棵类别树对象|
|后置条件|返回设置好每一层元素与层间元素的父子关系的类别树对象|
|**ClassicationTree.getTree**||
|语法|public ClassificationTreeVO getTree();|
|前置条件|无|
|后置条件|返回一棵层元素以及层间关系都设置好的类别树对象|

|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
|commodityDataService.GoodsClassificationDataService.finds()|获得所有类别|

ID的接口规范  

|提供的服务（供接口）||
| :--- | :--- |
|**ID.rootClassificationID**||
|语法|public String rootClassificationID();|
|前置条件|无|
|后置条件|返回一个新的根类别的ID|
|**ID.sonClassificationID**||
|语法|public String sonClassificationID(String fatherClassification);|
|前置条件|存在同ID的类别|
|后置条件|返回一个新的子类别的ID|
|**ID.setNewGoodsID**||
|语法|public String newGoodsID(String classification);|
|前置条件|存在同ID的类别|
|后置条件|返回一个新的商品的ID|

|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
|commodityDataService.GoodsClassificationDataService.finds()|获得所有类别|
|commodityDataService.GoodsClassificationDataService.find(String classification)|获得目标类别|

UpdateClassificationStructure的接口规范  


|提供的服务（供接口）||
| :--- | :--- |
|**UpdateClassificationStructure.addSon**||
|语法|public boolean addSon(ClassificationVO sonClassification);|
|前置条件|无|
|后置条件|完成父类别中增加子类别，返回增加成功的boolean|
|**UpdateClassificationStructure.deleteSon**||
|语法|public boolean deleteSon(ClassificationVO sonClassification);|
|前置条件|无|
|后置条件|完成父类别中删除子类别，返回删除成功的boolean|

|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
|commodityDataService.GoodsClassificationDataService.find(String ClassificationID)|获得目标类别|
|commodityDataService.GoodsClassificationDataService.update(ClassificationPO classification)|更新目标类别|

UpdateClassificationOfGoods的接口规范  

|提供的服务（供接口）||
| :--- | :--- |
|**UpdateClassificationOfGoods.updateOldClassification**||
|语法|public boolean updateOldClassification(String goodsID)|
|前置条件|存在同ID的商品对象|
|后置条件|更新该商品原来的类别的信息，即在该类别的商品清单中删除该商品,返回更新成功的boolean|
|**UpdateClassificationOfGoods.updateNewClassification**||
|语法|public boolean updateNewClassification(GoodsVO goods)|
|前置条件|无|
|后置条件|更新该商品新的所属类别的信息，即在该类别的商品清单中增加该商品,返回更新成功的boolean,**如果失败，即意味着该商品新类别非叶节点，不可以增加商品**|
|**UpdateClassificationOfGoods.updateGoodsClassification**||
|语法|public boolean updateGoodsClassification(GoodsVO goods)|
|前置条件|无|
|后置条件|更新该商品信息，返回更新成功的boolean|
|**UpdateClassificationOfGoods.updateClassificationOfGoods**||
|语法|public boolean updateClassificationOfGoods(GoodsVO goods)|
|前置条件|无|
|后置条件|更新该商品旧类别信息、新类别信息以及该商品信息,返回更新成功的bool值，**如果失败，即意味着该商品新类别非叶节点，不可以增加商品**|

|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
|commodityDataService.GoodsClassificationDataService.find(String ClassificationID)|获得目标类别|
|commodityDataService.GoodsClassificationDataService.update(ClassificationPO classification)|更新目标类别|
|commodityDataService.GoodsClassificationDataService.find(String goodsID)|获得目标商品|
|commodityDataService.GoodsDataService.update(GoodsPO goods)|更新商品信息|  


addGoodsBlController的接口规范  

|提供的服务（供接口）||
| :--- | :--- |
|**AddGoodsBlController.addNewGoods**||
|语法|public boolean addNewGoods(GoodsVO goodsVO,StockInOutVO stockVO) throws RemoteException; |
|前置条件|启动一个增加新商品的回合|
|后置条件|自动生成一个新的商品编号，存储新商品信息与入库信息，更新商品数据，更新类别数据，返回增加成功的boolean|
|**AddGoodsBlController.add**||
|语法|public boolean add(StockInOutVO vo) throws RemoteException;|
|前置条件|启动一个增加商品的回合|
|后置条件|存储商品的入库信息，更新出入库情况数据，更新成功的boolean|  

|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
|UpdateClassificationOfGoods.updateNewClassification(GoodsVO goods)|更新所属父类别商品清单|
|commodityDataService.GoodsDataService.insert（GoodsPO po）|插入新商品|
|ID.newGoodsID(String classification);|生成新商品的ID|
|commodityDataService.StockInOutRecordService.insert(StockInOutPO po)|插入一条出入库情况信息|
|UpdateGoodsAfterStock.update(StockInOutVO vo)|更新商品数据|

DeleteGoodsBlController的接口规范  

|提供的服务（供接口）||
| :--- | :--- |
|**DeleteGoodsBlController.delete**||
|语法|public boolean delete(StockInOutVO VO) throws RemoteException; |
|前置条件|开启一个减少商品回合|
|后置条件|存储商品的出库信息，更新出入库情况数据，返回更新成功的boolean|
|**DeleteGoodsBlController.obsoleteGoods**||
|语法|public boolean obsoleteGoods(String goodsNum) throws RemoteException;|
|前置条件|开启一个删除商品的回合|
|后置条件|彻底删除一个商品，更新商品数据，更新类别数据，返回删除成功的boolean|
|**DeleteGoodsBlController.compareToWarning**||
|语法|public int compareTowarning(String goodsTag，int currentAmount) throws RemoteException;|
|前置条件|商品减少|
|后置条件|返回该商品警戒值和该商品当前系统库存的差值|

|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
|commodityDataService.GoodsDataService.delete(GoodsPO po)|删除一个商品|
|UpdateClassificationOfGoods.updateOldClassification(GoodsVO goods)|更新所属父类别商品清单|
|UpdateGoodsAfterStock.update(StockInOutVO vo)|更新商品数据|
|commodityDataService.StockInOutRecordService.insert(StockInOutPo po)|插入一条出入库情况信息|
|WarningValue.getWarningValue(String goodsID)|获取该商品的警戒值|


WarningValue的接口规范   


|提供的服务（供接口）||
| :--- | :--- |
|**WarningValue.getWarningValue**||
|语法|public int getWarningValue(String goodsID);|
|前置条件|存在同ID的商品|
|后置条件|返回商品的警戒值|

|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
|commodityDataService.StockInOutRecordService.finds(String goodsID)|获得某商品的所有出入库记录|

UpdateGoodsAfterStock的接口规范   


|提供的服务（供接口）||
| :--- | :--- |
|**UpdateGoodsAfterStock.updateAmountAndPrice(StockInOutVO vo)**||
|语法|public boolean updateAmountAndPrice(StockInOutVO vo);|
|前置条件|无|
|后置条件|更新商品库存数据和最新零售价或者最近进价，返回更新成功的boolean|
|**UpdateGoodsAfterStock.update(StockInOutVO vo)**||
|语法|public boolean update(StockInOutVO vo);|
|前置条件|无|
|后置条件|商品出入库后，完成商品信息的更新，返回更新成功的boolean|

|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
|commodityDataService.GoodsClassificationDataService.find(String goodsID);|获得目标商品对象|
|commodityDataService.GoodsDataService.update（GoodsPO po）|更新商品信息（库存）|


GoodsInforBlController模块的接口规范  


|提供的服务（供接口）||
| :--- | :--- |
|**GoodsInforBlController.ifGoodsExist**||
|语法|public boolean ifGoodsExist(String goodsTag) throws RemoteException; |
|前置条件|开启一个商品查找回合|
|后置条件|返回该标识的商品是否存在的boolean|
|**GoodsInforBlController.goodsINfor**||
|语法|public GoodsVO goodsINfor(String goodsTag) throws RemoteException;|
|前置条件|开启一个商品信息查询回合|
|后置条件|返回一个商品对象|
|**GoodsInforBlController.modifyGoodsInfor**||
|语法|public boolean modifyGoodsInfor(GoodsVO vo) throws RemoteException;|
|前置条件|开启一个商品信息修改回合|
|后置条件|修改一个商品的信息，返回修改成功的boolean|
|**GoodsInforBlController.getGoodsList**||
|语法|public GoodsListVO getGoodsList() throws RemoteException;|
|前置条件|无|
|后置条件|返回商品清单vo对象|

|需要的服务（供接口）||
| :--- | :--- |
|**服务名**|**服务**|
|commodityDataService.GoodsDataService.finds|获得所有商品|
|commodityDataService.GoodsDataService.find(String goodsTag)|获得某个商品的信息|
|UpdateClassificationOfGoods.updateClassificationOfGoods(GoodsVO goods);|实现对商品类别的修改，包括商品信息的修改，和类别信息的修改(*注：先判断是否修改了类别信息，如果修改了，就调这个方法，不调下面这个，否则只调下面这个*)|
|commodityDataService.GoodsDataService.update(GoodsPO po)|更新某个商品|


StockCheckBlController模块的接口规范  


|提供的服务（供接口）||
| :--- | :--- |
|**StockCheckBlController.stockCheckSheet**||
|语法|public StockCheckSheetVO stockCheckSheet(String beginTime,String endTime) throws RemoteException; |
|前置条件|开启一个库存审查回合|
|后置条件|返回库存审查表对象|

|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
|CheckSheet.getStockCheckSheet(String beginTime,String endTime)|获得该段时间内出入库信息的ArrayList，即取得StockCheckSheetVO的内容|

InventoryCheckBlController模块的接口规范  


|提供的服务（供接口）||
| :--- | :--- |
|**InventoryCheckBlController.inventoryCheckSheet**||
|语法|public InventoryCheckSheetVO inventoryCheckSheet() throws RemoteException; |
|前置条件|开启一个库存盘点回合|
|后置条件|返回一个库存快照表对象|

|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
|CheckSheet.getInventoryCheckSheet()|获得当天库存情况的ArrayList，即取得InventoryCheckSheetVO的内容|


CheckSheet的接口规范  


|提供的服务（供接口）||
| :--- | :--- |
|**CheckSheet.getStockCheckSheet**||
|语法|public ArrayList<String[]> getStockCheckSheet(String beginTime,String endTime);|
|前置条件|无|
|后置条件|返回这段时间内出入库信息的ArrayList，每一条信息是一个String数组|
|**CheckSheet.getInventoryCheckSheet**||
|语法|public ArrayList<String[]> getInventoryCheckSheet(); |
|前置条件|无|
|后置条件|返回当天库存情况信息的ArrayList，每一条信息是一个String数组|
|**CheckSheet.getAveragePrice**||
|语法|public int getAveragePrice(String goodsID);|
|前置条件|存在同ID的商品|
|后置条件|返回该商品的库存均价|
|**CheckSheet.getProductionDate**||
|语法|public String getAveragePrice(String goodsID);|
|前置条件|存在同ID的商品|
|后置条件|返回该商品的出厂日期|

|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
|commodityDataService.StockInOutRecordService.finds(String beginTime,String endTime)|根据时间段查找给时间段内的出入库情况信息|
|commodityDataService.GoodsDataService.finds()|获得所有商品对象|
|commodityDataService.StockInOutRecordService.finds(String goodsID)|获得某商品的所有出入库记录|

ActualInventoryCheckBlController模块的接口规范  


|提供的服务（供接口）||
| :--- | :--- |
|ActualInventoryCheckBlController.actualInventoryCheck||
|语法|public int actualInventoryCheck(String goodsID,int actualAmount) throws RemoteException; |
|前置条件|开启一个实际库存确认回合|
|后置条件|返回该实际库存值和该商品当前系统库存的差值（*根据产生的通过的库存报溢或报损单出入库更新商品数据，而不是现在更新*）|

|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
|commodityDataService.GoodsDataService.find(String goodsTag)|获得某个商品的信息|


SaveBillBlController模块的接口规范  


|提供的服务（供接口）||
| :--- | :--- |
|**SaveBillBlController.saveInventoryWarningBill**||
|语法|public boolean saveInventoryWarningBill(InventoryWarningBillVO  bill) throws RemoteException;|
|前置条件|无|
|后置条件|返回保存库存警戒单成功的boolean|
|**SaveBillBlController.saveInventoryLossBill**||
|语法|public boolean saveInventoryLossBill(InventoryLossBillVO  bill) throws RemoteException;|
|前置条件|无|
|后置条件|返回保存库存报损单成功的boolean|
|**SaveBillBlController.saveInventoryOverBill**||
|语法|public boolean saveInventoryOverBill(InventoryOverBillVO  bill) throws RemoteException;|
|前置条件|无|
|后置条件|返回保存库存报溢单成功的boolean|

|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
|billBlService.CreateBillBlService.createInventoryWarningBill(InventoryWarningBillVO bill)|保存库存警戒单到单据数据中|
|billBlService.CreateBillBlService.createInventoryLossBill(InventoryLossBillVO bill)|保存库存报损单到单据数据中|
|billBlService.CreateBillBlService.createInventoryOverBill(InventoryOverBillVO bill)|保存库存报溢单到单据数据中|



（4）业务逻辑层的动态模型  

图4.4.1(4)-1
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/详细设计%20仓库管理员%20设计类图%20顺序图%20状态图/图1.png)
表明了xx灯具企业管理系统中，当用户选择库存分类管理后，界面上获得类别树的业务逻辑处理的相关对象之间的协作。  

图4.4.1(4)-2
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/详细设计%20仓库管理员%20设计类图%20顺序图%20状态图/图2.png)
表明了xx灯具企业管理系统中，当用户进行库存分类管理时（包括商品类别的增删改查），业务逻辑处理的相关对象之间的协作。  

图4.4.1(4)-3
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/详细设计%20仓库管理员%20设计类图%20顺序图%20状态图/图3.png)
表明了xx灯具企业管理系统中，当用户进行增加商品（包括入库）时业务逻辑处理的相关对象之间的协作。  

图4.4.1(4)-4
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/详细设计%20仓库管理员%20设计类图%20顺序图%20状态图/图4.png)
表明了xx灯具企业管理系统中，当用户进行删除商品（包括出库）业务逻辑处理的相关对象之间的协作。  

图4.4.1(4)-5
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/详细设计%20仓库管理员%20设计类图%20顺序图%20状态图/图5.png)
表明了xx灯具企业管理系统中，当用户进行商品信息的查询或者修改时业务逻辑处理的相关对象之间的协作。  

图4.4.1(4)-6
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/详细设计%20仓库管理员%20设计类图%20顺序图%20状态图/图6.png)
表明了xx灯具企业管理系统中，当用户进行库存审查时业务逻辑处理的相关对象之间的协作。  

图4.4.1(4)-7
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/详细设计%20仓库管理员%20设计类图%20顺序图%20状态图/图7.png)
表明了xx灯具企业管理系统中，当用户进行库存盘点时业务逻辑处理的相关对象之间的协作。  
  
图4.4.1(4)-8
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/详细设计%20仓库管理员%20设计类图%20顺序图%20状态图/图8.png)
表明了xx灯具企业管理系统中，当用户进行实际库存确认时业务逻辑处理的相关对象之间的协作。  

图4.4.1(4)-9
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/详细设计%20仓库管理员%20设计类图%20顺序图%20状态图/图9.png)
表明了xx灯具企业管理系统中，当用户进行库存出单时业务逻辑处理的相关对象之间的协作。  

图4.4.1(4)-10
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/详细设计%20仓库管理员%20设计类图%20顺序图%20状态图/图10.png)
所示状态图描述了获得类别树操作期间的状态序列、引起转移的事件、以及因状态转移而伴随的动作。随着getTree()被GoodsClassficationController调用，进入ClassificationTree状态，然后通过finds(),进入ClassificationData状态，然后从此返回ClassificationTree状态。再通过建立，进入ClassificationTreeVO状态，ClassificationTreeVO自己调用两个set方法（setClassificationLayer(ArrayList<String[]>)和setSonFatherConnection(ArrayList<String[]>)）并返回。然后返回ClassificationTree状态，最后结束。  

图4.4.1(4)-11
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/详细设计%20仓库管理员%20设计类图%20顺序图%20状态图/图11.png)
所示状态图描述了增加类别操作期间的状态序列、引起转移的事件、以及因状态转移而伴随的动作。随着addNewClassification(ClassificationVO vo)/addClassification(ClassificationVO vo)被commodityUi.GoodsClassificationUi调用，进入GoodsClassificationController状态，然后通过rootClassificationID()/sonClassificationID(String father),进入ID状态，后返回GoodsClassificationController状态。再通过调用addSon(ClassificationVO vo)，进入UpdateClassificationStructure状态，然后再调用find(String tag)/update(ClassificationPO po)进入GoodsClassificationData状态，之后返回UpdateClassificationStructure状态。然后从UpdateClassificationStructure状态返回GoodsClassificationController状态。接着从GoodsClassificationController状态通过调用insert(ClassificationVO vo)进入GoodsClassificationData状态，之后返回GoodsClassificationController状态。最后结束。  

图4.4.1(4)-12
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/详细设计%20仓库管理员%20设计类图%20顺序图%20状态图/图12.png)
所示状态图描述了修改类别操作期间的状态序列、引起转移的事件、以及因状态转移而伴随的动作。在Ui层调用modifyClassificationOfGoods(GoodsVO vo)进入GoodsClassificationController状态。然后调用updateClassificationOfGoods(GoodsVO vo)进入UpdateClassificationOfGoods状态。后自身调用updateOldClassificatin(String tag)/
updateNewClassification(GoodsVO vo)/
updateGoodsClassification(GoodsVO vo)方法并返回。后调用find(String tag)/update(ClassificataionVO vo)进入GoodsClassificationData状态，然后返回UpdateClassificationOfGoods状态。后调用update(GoodsVO vo)进入GoodsData状态，然后返回UpdateClassificationOfGoods状态。然后从UpdateClassificationOfGoods状态返回GoodsClassificationController状态。最后结束。  

图4.4.1(4)-13
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/详细设计%20仓库管理员%20设计类图%20顺序图%20状态图/图13.png)
所示状态图描述了删除类别操作期间的状态序列、引起转移的事件、以及因状态转移而伴随的动作。 在UI层调用 deleteClassification（ClassificationVO vo）进入GoodsClassificationController状态。然后通过调用deleteSon(ClassificationVO vo)进入UpdateClassificationStructure状态，再通过调用find(String tag)或update(ClassificationPO po)进入GoodsClassificationData状态，然后返回UpdateClassificationStructure状态，最后返回GoodsClassificationController状态。通过调用delete(ClassificationPO po)，从GoodsClassificationController状态进入GoodsClassificationData状态，然后返回GoodsClassificationController状态。最后从GoodsClassificationController状态至结束。  


图4.4.1(4)-14
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/详细设计%20仓库管理员%20设计类图%20顺序图%20状态图/图14.png)
所示状态图描述了获得类别信息操作期间的状态序列、引起转移的事件、以及因状态转移而伴随的动作。在UI层调用classificationInfor(String tag)或ifClassificationExists(String tag)方法，进入GoodsClassificationController状态。然后调用find(String tag)进入GoodsClassificationData状态。之后返回GoodsClassificationController状态。最后结束。  


图4.4.1(4)-15
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/详细设计%20仓库管理员%20设计类图%20顺序图%20状态图/图15.png)
所示状态图描述了修改类别信息操作期间的状态序列、引起转移的事件、以及因状态转移而伴随的动作。在UI层调用modifyClassificationInfor(ClassificationVO vo)方法进入GoodsClassificationController状态。然后通过调用addSon(ClassificationVO vo)或deleteSon(ClassificationVO vo)方法进入UpdateClassificationStructure状态。后通过调用find(String tag)或update(ClassificationPO po)进入GoodsClassificationData状态。然后从GoodsClassificationData状态返回UpdateClassificationStructure状态，再返回GoodsClassificationController状态。通过调用update(ClassificationPO po)还可以从GoodsClassificationController状态直接进入GoodsClassificationData状态，然后返回GoodsClassificationController状态。最后结束。  


图4.4.1(4)-16
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/详细设计%20仓库管理员%20设计类图%20顺序图%20状态图/图16.png)
所示状态图描述了增加商品（商品入库）操作期间的状态序列、引起转移的事件、以及因状态转移而伴随的动作。 在UI层调用addNewGoods(GoodsVO goodsVO,
StockInOutVO stockVO)或
add(StockInOut VO vo) 方法，进入addGoodsController状态，然后通过调用setNewGoodsID(String father)方法进入ID状态，然后返回addGoodsController状态；再从addGoodsController状态调用updateNewClassification(GoodsVO vo)进入UpdateClassificationOfGoods状态，后返回addGoodsController状态；通过调用update(StockInOutVO vo)进入UpdateGoodsAfterStock状态，此状态自身调用updateAmountAndPrice(StockInOutVO vo)方法，并通过调用find（String tag）或update(GoodsPO po)进入GoodsData状态，然后返回UpdateGoodsAfterStock状态，最后返回addGoodsController状态；通过调用UpdateNewClassification(GoodsVO vo)从addGoodsController状态进入UpdateClassificationOfGoods状态，然后返回addGoodsController状态；在addGoodsController状态还可以直接调用insert(GoodsPO po)直接进入GoodsData状态，然后返回addGoodsController状态；通过调用insert(StockInOutPO po)方法还可以从addGoodsController状态直接进入StockInOutRecord状态，然后返回addGoodsController状态。最后结束。  


图4.4.1(4)-17
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/详细设计%20仓库管理员%20设计类图%20顺序图%20状态图/图17.png)
所示状态图描述了减少商品（商品出库）期间的状态序列、引起转移的事件、以及因状态转移而伴随的动作。在UI层调用delete(StockInOutVO vo)或
obsolete(GoodsVO vo)或
compareToWarning
(String ID,int cuurentAmount)方法，进入deleteGoodsController状态。然后调用update(StockInOutVO vo)进入UpdateGoodsAfterStock状态，此状态自身调用updateAmountAndPrice(StockInOutVO vo)方法，并通过调用find（String tag）或update(GoodsPO po)进入GoodsData状态，然后返回UpdateGoodsAfterStock状态，最后返回deleteGoodsController状态；通过调用updateOldClassification（String goodsID）进入UpdateClassificationOfGoods状态，然后返回deleteGoodsController状态；在deleteGoodsController状态还可以直接调用insert(GoodsPO po)直接进入GoodsData状态，然后返回addGoodsController状态；通过调用getWarningValue(String goodsID)可以进入WarningValue状态，然后调用find(String goodsID)进入StockInOutRecord状态，然后返回WarningValue状态，最后返回deleteGoodsController状态；通过调用insert(StockInOutPO po)方法还可以从deleteGoodsController状态直接进入StockInOutRecord状态，然后返回deleteGoodsController状态。最后结束。  


图4.4.1(4)-18
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/详细设计%20仓库管理员%20设计类图%20顺序图%20状态图/图18.png)
所示状态图描述了商品信息管理操作期间的状态序列、引起转移的事件、以及因状态转移而伴随的动作。UI层调用ifGoodsExist(String tag)或
goodsInfor(String tag)或
modifyGoodsInfor(GoodsVO vo)进入GoodsInforController状。然后通过调用UpdateClassificationOfGoods(GoodsVO vo)进入UpdateClassificationOfGoods状态，然后返回GoodsInforController状态；通过find(String GoodsTag)或update(GoodsPO po)进入GoodsData状态，然后返回GoodsInforController状态。最后结束。  


图4.4.1(4)-19
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/详细设计%20仓库管理员%20设计类图%20顺序图%20状态图/图19.png)
所示状态图描述了库存审查操作期间的状态序列、引起转移的事件、以及因状态转移而伴随的动作。UI层调用StockCheckSheet(String begin,String end)进入StockCheckController状态。然后通过getStockCheckSheet(String beginTime,String endTime)进入CheckSheet状态，之后调用finds(String begin,String end)进入StockInOutRecord状态，后返回CheckSheet状态，最后返回StockCheckController状态。最后结束。  


图4.4.1(4)-20
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/详细设计%20仓库管理员%20设计类图%20顺序图%20状态图/图20.png)
所示状态图描述了库存盘点操作期间的状态序列、引起转移的事件、以及因状态转移而伴随的动作。UI层调用InventoryCheckSheet()方法进入InventoryCheckController状态，然后通过调用getInventoryCheckSheet()进入CheckSheet状态，然后CheckSheet状态通过调用finds(String goodsID)进入StockInOutRecord状态，后返回CheckSheet状态；CheckSheet状态也通过调用finds()进入GoodsData状态，然后返回CheckSheet状态；CheckSheet状态还会自身调用getProductionDate
(String goodsID)和getAveragePrice(String goodsID)方法。最后从CheckSheet状态返回InventoryCheckController状态，最后结束。  


图4.4.1(4)-21
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/详细设计%20仓库管理员%20设计类图%20顺序图%20状态图/图21.png)
所示状态图描述了实际库存确认操作期间的状态序列、引起转移的事件、以及因状态转移而伴随的动作。UI层调用actualInventoryCheck(String goodsID,int actualAmount)进入ActualInventoryCheckController状态，然后通过调用find(String tag)进入GoodsData状态，后返回ActualInventoryCheckController状态，最后结束。  



图4.4.1(4)-22
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/详细设计%20仓库管理员%20设计类图%20顺序图%20状态图/图22.png)
所示状态图描述了库存出单操作期间的状态序列、引起转移的事件、以及因状态转移而伴随的动作。UI层调用saveInventoryWarningBill(InventoryWarningBillVO vo)或
saveInventoryOverBill(InventoryOverBillVO vo)或saveInventoryLossBill(InventoryLossBillVO vo)方法进入SaveBillController状态，然后通过调用createInventoryWarningBill(InventoryWarningBillVO vo)或
createInventoryOverBill(InventoryOverBillVO vo)或createInventoryLossBill(InventoryLossBillVO vo)进入CreateBillService状态，后返回SaveBillController状态，最后结束。  



（5）业务逻辑层的设计原理  
利用委托式风格，每个界面需要访问的业务逻辑由各自的控制器委托给不同的领域对象。  
其他略。  

####4.1.2、logBl模块  
（1）模块概述  
logBl模块承担的需求参见需求规格说明文档功能需求及非相关非功能需求。    
logBl模块的职责及接口参见软件体系结构描述文档。  
（2）整体结构  
根据体系结构的设计，我们将系统分为展示层、业务逻辑层、数据层。每一层之间为了增加灵活性，我们会添加接口。比如展示层和业务逻辑层之间，我们添加blService.logBlService.LogBlService接口。业务逻辑层和数据层之间添加dataService.userDataService.UserDataService等接口。为了隔离业务逻辑职责和逻辑控制职责，我们增加了LogBlController，这样LogBlController会将对用户注册和登录的业务逻辑委托给logBl对象。
logBl模块的设计如图（**设计类图链接**）所示。  

logBl模块各个类的职责如下表所示  

|模块|职责|
| :--- | :--- |
|LogBlController|负责管理实现对应于用户注册、登录和修改密码界面所需要的服务|
|LogBl|完成对用户的新建、验证和修改密码任务|
（3）模块内部类的接口规范   

LogBlController的接口规范  

|提供的服务（供接口）||
| :--- | :--- |
|**LogBlController.isValidUser**||
|语法|public boolean isValidUser(String userId, String password)|
|前置条件|系统中已存在该用户|
|后置条件|调用LogBl领域对象的isValidUser方法|
|**LogBlController.registerUser**||
|语法|public boolean registerUser(String userId, String password)|
|前置条件|管理员已经在系统中添加了该用户|
|后置条件|调用LogBl领域对象的registerUser方法|
|**LogBlController.changePassword**||
|语法|public boolean changePassword(String userId, String oldPassword, String password)|
|前置条件|系统中已存在该用户|
|后置条件|调用LogBl领域对象的changePassword方法|

|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
|LogBl.isValidUser(String userId, String password)|判断是否为合法用户|
|LogBl.registerUser(String userId, String password)|新建一个用户|
|LogBl.changePassword(String userId, String oldPassword, String password)|修改用户密码|

LogBl的接口规范  

|提供的服务（供接口）||
| :--- | :--- |
|**LogBl.isValidUser**||
|语法|public boolean isValidUser(String userId, String password)|
|前置条件|启动一个用户登录回合|
|后置条件|根据输入信息判断是否允许登录|
|**LogBl.registerUser**||
|语法|public boolean registerUser(String userId, String password)|
|前置条件|启动一个用户注册回合|
|后置条件|持久化更新涉及的用户账号密码的表项|
|**LogBl.changePassword**||
|语法|public boolean changePassword(String userId, String oldPassword, String password)|
|前置条件|用户账号密码的表项中存在该用户记录|
|后置条件|持久化更新涉及的用户账号密码的表项|

|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
|UserDataService.isValidUser(String userId, String password)|根据字段名查找并比较值|
|UserDataService.registerUser(String userId, String password)|插入单一持久化信息|
|UserDataService.changePassword(String userId, String oldPassword, String password)|更新单一持久化信息|

####4.1.3、CustomerBl模块  
（1）模块概述  
CustomerBl模块承担的需求参见需求规格说明文档功能需求及非相关非功能需求。  
CustomerBl模块的职责及接口参见软件体系结构描述文档。  

（2）整体结构  
展示层和业务逻辑层之间，我们添加blService.customerBlService.CustomerBlService接口。业务逻辑层和数据层之间添加dataService.customerDataService.CustomerDataService接口。为了隔离业务逻辑职责和逻辑控制职责，我们增加了CustomerBlController，这样CustomerBlController会将对客户管理的业务逻辑委托给CustomerBl对象。customerVO、customerPO是作为客户信息的持久化对象被添加到设计模型中去的。  

CustomerBl模块各个类的职责如下表所示  

|模块|职责|
| :--- | :--- |
|CustomerBlController|负责管理实现对应于进货销售人员客户管理界面所需要的服务|
|CustomerBl|完成对客户的增删改查任务|

（3）模块内部类的接口规范   

CustomerBlController的接口规范   

|提供的服务（供接口）||
| :--- | :--- |
|**CustomerBlController.AddCustomer**||
|语法|public boolean AddCustomer(CustomerVO vo)|
|前置条件|操作人员选择了客户管理任务中的增加客户|
|后置条件|调用CustomerBl领域对象的AddCustomer方法|
|**CustomerBlController.DelCustomer**||
|语法|public boolean DelCustomer(String number, String name)|
|前置条件|操作人员选择了客户管理任务中的删除客户|
|后置条件|调用CustomerBl领域对象的DelCustomer方法|
|**CustomerBlController.ModCustomer**||
|语法|public boolean ModCustomer(CustomerVO vo)|
|前置条件|操作人员选择了客户管理任务中的修改客户信息|
|后置条件|调用CustomerBl领域对象的ModCustomer方法|
|**CustomerBlController.QueryCustomer**||
|语法|public CustomerVO QueryCustomer(String name)|
|前置条件|操作人员选择了客户管理任务中的查询客户信息|
|后置条件|调用CustomerBl领域对象的QueryCustomer方法|

|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
|CustomerBl.AddCustomer(CustomerVO vo)|增加一个客户|
|CustomerBl.DelCustomer(String number, String name)|删除一个客户|
|CustomerBl.ModCustomer(CustomerVO vo)|修改客户信息|
|CustomerBl.QueryCustomer(String name)|查询客户信息|

CustomerBl的接口规范  

|提供的服务（供接口）||
| :--- | :--- |
|**CustomerBl.AddCustomer**||
|语法|public boolean AddCustomer(CustomerVO vo)|
|前置条件|启动一个客户管理任务回合|
|后置条件|在一个客户管理任务中，增加一个客户|
|**CustomerBl.DelCustomer**||
|语法|public boolean DelCustomer(String number, String name)|
|前置条件|启动一个客户管理任务回合|
|后置条件|在一个客户管理任务中，删除一个客户|
|**CustomerBl.ModCustomer**||
|语法|public boolean ModCustomer(CustomerVO vo)|
|前置条件|启动一个客户管理任务回合|
|后置条件|在一个客户管理任务中，修改一个客户的客户信息|
|**CustomerBl.QueryCustomer**||
|语法|public CustomerVO QueryCustomer(String name)|
|前置条件|启动一个客户管理任务回合|
|后置条件|在一个客户管理任务中，显示一个客户的客户信息|
|**CustomerBl.Provide**||
|语法|public boolean Provide(String number, double amount)|
|前置条件|启动一个单据处理任务回合|
|后置条件|在一个单据处理任务中，修改一个客户的应收应付信息|

|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
| customerDataService.insert(CustomerVo vo) | 插入单一持久化对象 |
| customerDataService.delete(String number, String name) | 删除单一持久化对象 |
| customerDataService.update(CustomerPo vo) | 更新单一持久化对象 |
| customerDataService.find(String name) | 根据ID进行查找持久化对象 |

####4.1.4、SalesBl模块  
（1）模块概述  
SalesBl模块承担的需求参见需求规格说明文档功能需求及非相关非功能需求。   
SalesBl模块的职责及接口参见软件体系结构描述文档。  

（2）整体结构  
展示层和业务逻辑层之间，我们添加blService.salesBlService.SalesBlService接口为了隔离业务逻辑职责和逻辑控制职责，我们增加了SalesBlController，这样SalesBlController会将对客户管理的业务逻辑委托给SalesBl对象。BillVO、BillPO是作为客户信息的持久化对象被添加到设计模型中去的。  

|模块|职责|
| :--- | :--- |
|SalesBlController|负责管理实现对应于进货销售人员制定单据界面所需要的服务|
|SalesBl|完成新建进货单、进货退货单、出货单、出货退货单任务|


（3）模块内部类的接口规范  

SalesBlController的接口规范   


|提供的服务（供接口）||
| :--- | :--- |
| **SalesBlController.NewPurchase** |  |
| 语法 | public boolean NewPurchase(PurchaseBillVo vo) |
| 前置条件 | 操作人员在制定单据任务中选择了新建一张供应商进货单 |
| 后置条件 | 调用SalesBl领域对象的NewPurchase方法 |
| **SalesBlController.NewPurReturn** |  |
| 语法 | public boolean NewPurReturn(PurchaseReturnBillVo vo) |
| 前置条件 | 操作人员在制定单据任务中选择了新建一张供应商进货退货单 |
| 后置条件 | 调用SalesBl领域对象的NewPurReturn方法 |
| **SalesBlController.NewSales** |  |
| 语法 | public boolean NewSales(SalesBillVo vo) |
| 前置条件 | 操作人员在制定单据任务中选择了新建一张销售商出货单 |
| 后置条件 | 调用SalesBl领域对象的NewSales方法 |
| **SalesBlController.NewSalReturn** |  |
| 语法 | public boolean NewSalReturn(SalesReturnBillVo vo) |
| 前置条件 | 操作人员在制定单据任务中选择了新建一张销售商出货退货单 |
| 后置条件 | 调用SalesBl领域对象的NewSalReturn方法 |
| **SalesBlController.CommoditySelect** |  |
| 语法 | public arrayList< String > CommoditySelect() |
| 前置条件 | 操作人员在制定单据任务中选择商品 |
| 后置条件 | 调用SalesBl领域对象的CommoditySelect方法 |

|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
|SalesBl.NewPurchase(PurchaseBillVo vo)|新建一张供应商进货单|
|SalesBl.NewPurReturn(PurchaseReturnBillVo vo)|新建一张供应商进货退货单|
|SalesBl.NewSales(SalesBillVo vo)|新建一张销售商出货单|
|SalesBl.NewSalReturn(SalesReturnBillVo vo)|新建一张销售商出货退货单|
|SalesBl.CommoditySelect()|从商品列表中选择具体商品|

SalesBl的接口规范  


|提供的服务（供接口）||
| :--- | :--- |
| **SalesBl.NewPurchase** |  |
| 语法 | public boolean NewPurchase(PurchaseBillVo vo) |
| 前置条件 | 启动一个进货销售人员制定单据回合 |
| 后置条件 | 在一个制定单据回合中，新建一张供应商进货单 |
| **SalesBl.NewPurReturn** |  |
| 语法 | public boolean NewPurReturn(PurchaseReturnBillVo vo) |
| 前置条件 | 启动一个进货销售人员制定单据回合 |
| 后置条件 | 在一个制定单据回合中，新建一张供应商进货退货单 |
| **SalesBl.NewSales** |  |
| 语法 | public boolean NewSales(SalesBillVo vo) |
| 前置条件 | 启动一个进货销售人员制定单据回合 |
| 后置条件 | 在一个制定单据回合中，新建一张销售商出货单 |
| **SalesBl.NewSalReturn** |  |
| 语法 | public boolean NewSalReturn(SalesReturnBillVo vo) |
| 前置条件 | 启动一个进货销售人员制定单据回合 |
| 后置条件 | 在一个制定单据回合中，新建一张销售商出货退货单 |
| **SalesBl.CommoditySelect** |  |
| 语法 | public arrayList< String > CommoditySelect() |
| 前置条件 | 启动一个进货销售人员制定单据回合 |
| 后置条件 | 销售人员新建单据时商品列表中商品名称被填充 |

|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|createPurchaseBill(PurchaseBillVO bill) | 创建一张进货单的业务逻辑接口 |
| CreateBillBl.createPurchaseReturnBill(PurchaseReturnBillVO bill) | 创建一张进货退货单的业务逻辑接口 |
| CreateBillBl.createSalesBill(SalesBillVO bill) | 创建一张出货单的业务逻辑接口 |
| CreateBillBl.CreateSalesReturnBill(SalesReturnBillVO bill) | 创建一张进货退货单的业务逻辑接口 |
| CommodityBlService.GoodsInfoBlService.getGoodsList() | 得到商品列表的业务逻辑接口 |





（4）业务逻辑层的动态模型  
图1
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A11%E4%BD%9C%E4%B8%9A%E5%9B%BE/%E5%9B%BE1.png)
表明了xx灯具企业管理系统中，当用户输入了账号和密码之后，用户注册和登录业务逻辑处理的相关对象之间的协作。  
图2
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A11%E4%BD%9C%E4%B8%9A%E5%9B%BE/%E5%9B%BE2.png)
表明了xx灯具企业管理系统中，当用户做了新增客户操作之后，销售人员客户管理逻辑处理的相关对象之间的协作。  
图3
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A11%E4%BD%9C%E4%B8%9A%E5%9B%BE/%E5%9B%BE3.png)
表明了xx灯具企业管理系统中，当用户做了删除客户操作之后，销售人员客户管理逻辑处理的相关对象之间的协作。  
图4
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A11%E4%BD%9C%E4%B8%9A%E5%9B%BE/%E5%9B%BE4.png)
表明了xx灯具企业管理系统中，当用户做了修改客户信息操作之后，销售人员客户管理逻辑处理的相关对象之间的协作。  
图5
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A11%E4%BD%9C%E4%B8%9A%E5%9B%BE/%E5%9B%BE5.png)
表明了xx灯具企业管理系统中，当用户做了查询客户信息操作之后，销售人员客户管理逻辑处理的相关对象之间的协作。  
图6
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A11%E4%BD%9C%E4%B8%9A%E5%9B%BE/%E5%9B%BE6.png)
表明了xx灯具企业管理系统中，当用户做了新建一张供应商进货单操作之后，销售人员新建单据逻辑处理的相关对象之间的协作。  
图7
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A11%E4%BD%9C%E4%B8%9A%E5%9B%BE/%E5%9B%BE7.png)
表明了xx灯具企业管理系统中，当用户做了新建一张供应商进货退货单操作之后，销售人员新建单据逻辑处理的相关对象之间的协作。  
图8
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A11%E4%BD%9C%E4%B8%9A%E5%9B%BE/%E5%9B%BE8.png)
表明了xx灯具企业管理系统中，当用户做了新建一张销售商出货单操作之后，销售人员新建单据逻辑处理的相关对象之间的协作。  
图9
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A11%E4%BD%9C%E4%B8%9A%E5%9B%BE/%E5%9B%BE9.png)
表明了xx灯具企业管理系统中，当用户做了新建一张销售商出货退货单操作之后，销售人员新建单据逻辑处理的相关对象之间的协作。  
图10
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A11%E4%BD%9C%E4%B8%9A%E5%9B%BE/%E5%9B%BE10.png)
表明了xx灯具企业管理系统中，当用户做了查看供应商进货单操作之后单据信息显示逻辑处理的相关对象之间的协作。  
图11
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/blob/master/%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A11%E4%BD%9C%E4%B8%9A%E5%9B%BE/%E5%9B%BE11.png)
表明了xx灯具企业管理系统中，当用户做了查看供应商进货退货单操作之后单据信息显示逻辑处理的相关对象之间的协作。  
图12
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/blob/master/%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A11%E4%BD%9C%E4%B8%9A%E5%9B%BE/%E5%9B%BE12.png)
表明了xx灯具企业管理系统中，当用户做了查看销售商出货单操作之后单据信息显示逻辑处理的相关对象之间的协作。  
图13
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/blob/master/%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A11%E4%BD%9C%E4%B8%9A%E5%9B%BE/%E5%9B%BE13.png)
表明了xx灯具企业管理系统中，当用户做了查看销售商出货退货单操作之后单据信息显示逻辑处理的相关对象之间的协作。  
图14
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/blob/master/%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A11%E4%BD%9C%E4%B8%9A%E5%9B%BE/%E5%9B%BE14.png)
如图14所示的状态图描述了LogBl对象生存期间的状态序列、引起转移的事件，以及因状态转移而伴随的动作。随着isValidUser方法被UI调用，LogBl进入presentData状态；随着registerUser方法被UI调用，LogBl进入handleData状态，随后通过登录进入present状态；随着changePassword方法被UI调用，LogBl由presentData状态进入complete状态。  
图15
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/blob/master/%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A11%E4%BD%9C%E4%B8%9A%E5%9B%BE/%E5%9B%BE15.png)
如图15所示的状态图描述了CustomerBl对象生存期间的状态序列、引起转移的事件，以及因状态转移而伴随的动作。随着AddCustomer/DelCustomer/ModCustomer/QueryCustomer方法被调用，CustomerBl进入handleData状态，之后通过获取CustomerPO进入present状态;通过获取ResultMessage进入complete状态。  
图16
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/blob/master/%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A11%E4%BD%9C%E4%B8%9A%E5%9B%BE/%E5%9B%BE16.png)
如图16所示的状态图描述了SalesBl对象生存期间的状态序列、引起转移的事件，以及因状态转移而伴随的动作。随着NewPurchase/NewPurReturn/NewSales/NewSalReturn方法被调用，SalesBl进入handleData状态，之后通过获取ResultMessage进入complete状态。  
图17
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/blob/master/%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A11%E4%BD%9C%E4%B8%9A%E5%9B%BE/%E5%9B%BE17.png)
如图17所示的状态图描述了ViewSalsemanBillBl对象生存期间的状态序列、引起转移的事件，以及因状态转移而伴随的动作。随着getPurchaseBill/getPurchaseReturnBill/getSalesBill/getSalesReturnBill方法被调用，ViewSalsemanBillBl进入handleData状态，之后通过获取PurchaseBillVO/PurchaseReturnBillVO/SalesBillVO/SalesReturnBillVO进入present状态。  

（5）业务逻辑层的设计原理  
利用委托式风格，每个界面需要访问的业务逻辑由各自的控制器委托给不同的领域对象。  
其他略。  



###4.1.5 viewBillBl模块  
（1）模块概述  
viewBillBl模块承担的需求参见需求规格说明文档功能需求及非功能需求。viewBillBl模块的职责及接口参见软件体系结构描述文档。  

（2）整体结构  
viewBillBl模块的设计如图：  

viewBillBl模块各个类的职责如下表所示：  

|模块|职责|
|:---|:----|
|ViewFinanceStaffBillBlController|负责实现查看财务人员单据界面所需要的服务|
|ViewSalsemanBillBlController|查看销售人员制定的单据|
|ViewWareKeeperBillBlController|查看仓库管理制定的单据，包括库存报警单、报溢单、报损单|

（3）模块内部类的接口规范  

ViewFinanceStaffBillBlController的接口规范  

|提供的服务（供接口）||
|:----|:----|
|ViewFinanceStaffBillBlController.getPaymentBill||
|语法|public PaymentBillVO getPaymentBill(String billId)|
|前置条件|输入付款单单据编号|
|后置条件|调用ViewFinanceStaffBillBl领域对象的getPaymentBill方法|
|ViewFinanceStaffBillBlController.getRceiptBill||
|语法|public ReceiptBillVO getRceiptBill(String billId)|
|前置条件|输入收款单单据编号|
|后置条件|调用ViewFinanceStaffBillBl领域对象的getRceiptBill方法|
|ViewFinanceStaffBillBlController.getCashExpenseBill||
|语法|public CashExpenseBillVO getCashExpenseBill(String billId)|
|前置条件|输入现金费用单单据编号|
|后置条件|调用ViewFinanceStaffBillBl领域对象的getRceiptBill方法|

|需要的服务（需接口）||
|:----|:----|
|服务名|服务|
|GetBillBl|提供读取财务类单据的逻辑服务|

ViewSalsemanBillBlController的接口规范  

|提供的服务（供接口）||
| :--- | :--- |
| **ViewSalsemanBillBlController.getPurchaseBill** |  |
| 语法 | public PurchaseBillVO getPurchaseBill(String billNum) |
| 前置条件 | 操作人员选择查看供应商进货单信息 |
| 后置条件 | 调用GetSalesmanBillService的getBill方法 |
| **ViewSalsemanBillBlController.getPurchaseReturnBill** |  |
| 语法 | public PurchaseReturnBillVO getPurchaseReturnBill(String billNum) |
| 前置条件 | 操作人员选择查看供应商进货退货单信息 |
| 后置条件 | 调用GetSalesmanBillService的getBill方法 |
| **ViewSalsemanBillBlController.getSalesBill** |  |
| 语法 | public SalesBillVO getSalesBill(String billNum) |
| 前置条件 | 操作人员选择查看销售商出货单信息 |
| 后置条件 | 调用GetSalesmanBillService的getBill方法 |
| **ViewSalsemanBillBlController.getSalesReturnBill** |  |
| 语法 | public SalesReturnBillVO getSalesReturnBill(String billNum) |
| 前置条件 | 操作人员选择查看销售商出货退货单信息 |
| 后置条件 | 调用GetSalesmanBillService的getBill方法 |

|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
| GetSalesmanBillService.getBillByNameAndId(String billName,String billId) | 根据ID和名称进行查找持久化对象 |


ViewWareKeeperBillBlController接口规范  


|提供的服务（供接口）||
| :--- | :--- |
|**ViewWareKeeperBillBlController.getInventoryWarningBill**||
|语法|public InventoryWarningBillVO getInventoryWarningBill(String billID);|
|前置条件|存在同ID仓库报警单|
|后置条件|返回同ID仓库报警单对象vo|
|**ViewWareKeeperBillBlController.getInventoryLossBill**||
|语法|public InventoryLossBillVO getInventoryLossBill(String billID);|
|前置条件|存在同ID仓库报损单|
|后置条件|返回同ID仓库报损单对象vo|
|**ViewWareKeeperBillBlController.getInventoryOverBill**||
|语法|public InventoryOverBillVO getInventoryOverBill(String billID);|
|前置条件|存在同ID仓库报溢单|
|后置条件|返回同ID仓库报溢单对象vo|


|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
|billBlService.GetBillBl.getBillByNameAndId(String billType,String billID)|提供相同ID的库存警戒单|

（4）业务逻辑层的动态模型  
图X表明了连锁商店系统中，当用户单击某张单据以查看单据信息时，查看单据业务逻辑处理的相关对象之间的协作。  
图X为viewBillBl模块想要查看单据信息时候的状态图。  

（5）  


###4.2.6 billStateBl模块  
（1）模块概述  
billStateBl模块承担的需求参见需求规格说明文档功能需求及非功能需求。  
billStateBl模块的职责及接口参见软件体系结构描述文档。  
（2）整体结构  
billStateBl模块的设计如图：  

billStateBl模块各个类的职责如下表所示：  


|模块|职责|
|:---|:----|
|FinancialStaffBillStateBlController|负责财务人员查看单据状态界面所需的服务|
|SalesmanBillStateBlController|负责销售进货人员查看单据状态界面所需的服务|
|WareKeeperBillStateBlController|负责仓库管理人员查看单据状态界面所需的服务|

（3）模块内部类的接口规范  

FinancialStaffBillStateBlController的接口规范  


|提供的服务（供接口）||
|:----|:----|
|FinancialStaffBillStateBlController.getToMakeList||
|语法|public String[] getToMakeList()|
|前置条件|已产生通过审批的销售单和进货单，需要财务人员制定相应的收款单、付款单或现金费用单|
|后置条件|调用getToMakeList方法|
|FinancialStaffBillStateBlController.getUnpassedList||
|语法|public String[] getUnpassedList()|
|前置条件|产生未通过审核的财务类单据|
|后置条件|调用getUnpassedList方法|
|FinancialStaffBillStateBlController.getToDoList||
|前置条件|产生通过审核的财务类单据|
|后置条件|调用getToDoList方法|
|FinancialStaffBillStateBlController.getDoneList||
|前置条件|产生执行完毕的财务类单据|
|后置条件|调用getDoneList|
|FinancialStaffBillStateBlController.close||
|前置条件|用户需要关闭执行完毕的单据|
|后置条件|调用close方法|

|需要的服务（需接口）||
|:----|:----|
|服务|服务名|
|GetBillBl|读取财务人员单据状态逻辑服务|

WareKeeperBillStateBlController的接口规范  


|提供的服务（供接口）||
|:----|:----|
|WareKeeperBillStateBlController.getUnpassedList||
|语法|public String[] getUnpassedList()|
|前置条件|产生未通过审核的库存类单据|
|后置条件|调用getUnpassedList方法|
|WareKeeperBillStateBlController.getToDoList||
|前置条件|产生通过审核的进货单、销售退货单、库存报溢单|
|后置条件|调用getToDoList方法|
|WareKeeperBillStateBlController.getDoneList||
|前置条件|产生执行完毕的进货单、销售退货单、库存报溢单|
|后置条件|调用getDoneList|
|WareKeeperBillStateBlController.close||
|前置条件|用户需要关闭执行完毕的单据|
|后置条件|调用close方法|

|需要的服务（需接口）||
|:----|:----|
|服务|服务名|
|GetBillBl|读取仓库管理员单据状态逻辑服务|

SalesmanBillStateBlController的接口规范  


|提供的服务（供接口）||
|:----|:----|
|SalesmanBillStateBlController.getUnpassedList||
|语法|public String[] getUnpassedList()|
|前置条件|产生未通过审核的销售进货类单据|
|后置条件|调用getUnpassedList方法|
|SalesmanBillStateBlController.close||
|前置条件|用户需要关闭未通过审核的单据|
|后置条件|调用close方法|

|需要的服务（需接口）||
|:----|:----|
|服务|服务名|
|GetBillBl|读取销售进货员单据状态逻辑服务|

（4）业务逻辑层的动态模型  
图X表明了连锁商店系统中，当用户单击查看单据转台按钮时，查看单据状态业务逻辑处理的相关对象之间的协作。  
图X为billStateBl模块想要查看单据信息时候的状态图。  

（5）  


###4.1.7 financeBl模块  
（1）模块描述  
financeBl模块承担的需求参见需求规格说明文档功能需求及非功能需求。financeBl模块的职责及接口参见软件体系结构描述文档。  

（2）整体结构  
financeBl模块的设计如图：  

financeBl模块各个类的职责如下表所示：  


|模块|职责|
|:---|:----|
|BankAccountBlController|负责银行账户管理界面所需的服务|
|InOutBlController|负责账单管理界面所需的服务|
|NewFinanceBillsBlController|负责新建财务类单据界面所需的服务|


（3）模块内部类的接口规范  

BankAccountBlController的接口规范  


|提供的服务（供接口）||
|:----|:----|
|BankAccountBlController.newBankAccount||
|语法|public void newBankAccount(BankAccountVO toSave)|
|前置条件|用户已经输入新建的银行账户信息。|
|后置条件|调用newBankAccount方法|
|BankAccountBlController.viewBankAccounts||
|语法|public ArrayList<BankAccountVO> viewBankAccounts()|
|前置条件|无|
|后置条件|调用viewBankAccounts方法|
|BankAccountBlController.updateAccount||
|语法|public void updateAccount(String oldAccountName, String newAccountName)|
|前置条件|用户已经输入新的银行账户名|
|后置条件|调用updateAccount方法|
|BankAccountBlController.deleteAccount||
|语法|public void deleteAccount(String toDelete)|
|前置条件|无|
|后置条件|调用deleteAccount方法|

|需要的服务（需接口）||
|:----|:----|
|服务|服务名|
|BankAccountBl|提供银行账户管理逻辑实现的细节|

InOutBlController的接口规范  


|提供的服务（供接口）||
|:----|:----|
|InOutBlController.newInOut||
|语法|public void newInOut(InitialInfoVO initialInfo)|
|前置条件|用户已经输入期初信息|
|后置条件|调用newInOut方法|
|InOutBlController.viewInitialInformation||
|语法|public InitialInfoVO viewInitialInformation(String inOutYear)|
|前置条件|无|
|后置条件|调用getInitialInfo方法|
|InOutBlController.getDetails||
|语法|public InOutDetailsVO viewInOutDetails(String inOutYear)|
|前置条件|无|
|后置条件|调用getDetails方法|
|InOutBlController.autoAddEntry||
|语法|public void autoAddEntry(SingleEntryVO toAdd)|
|前置条件|有交易产生|
|后置条件|调用autoAddEntry方法|
|InOutBlController.getInOuts||
|语法|public String[] getInOutList()|
|前置条件|无|
|后置条件|调用getInOuts方法|

|需要的服务（需接口）||
|:----|:----|
|服务|服务名|
|InOutBl|提供账单管理逻辑实现的细节|

NewFinanceBillsBlController的接口规范  


|提供的服务（供接口）||
|:----|:----|
|NewFinanceBillsBlController.newCashExpenseBill||
|语法|public void newCashExpenseBill(CashExpenseBillVO toSave)|
|前置条件|用户已经输入现金费用单信息|
|后置条件|调用newCashExpenseBill方法|
|NewFinanceBillsBlController.newPaymentBill||
|语法|public void newPaymentBill(PaymentBillVO toSave)|
|前置条件|用户已经输入付款单信息|
|后置条件|调用newPaymentBill方法|
|NewFinanceBillsBlController.newReceiptBill||
|语法|public void newReceiptBill(ReceiptBillVO toSave)|
|前置条件|用户已经输入收款单信息|
|后置条件|调用newReceiptBill方法|

|需要的服务（需接口）||
|:----|:----|
|服务|服务名|
|NewFinanceBillsBl|提供新建财务类单据逻辑实现的细节|

（4）业务逻辑层的动态模型  
图X表明了连锁商店系统中，当用户进行财务操作时，财务操作业务逻辑处理的相关对象之间的协作。  
图X为financeBl模块想要进行财务操作时候的状态图。  

（5）  

###4.1.8 listBl模块  
（1）模块描述  
listBl模块承担的需求参见需求规格说明文档功能需求及非功能需求。listBl模块的职责及接口参见软件体系结构描述文档。  

（2）整体描述  
listBl模块的设计如图：  

listBl模块各个类的职责如下表所示：  


|模块|职责|
|:---|:----|
|BusinessConditionListBlController|负责经营情况表界面所需服务|
|BusinessProcessListBlController|负责经营历程表界面所需服务|
|NewModifyBillBlController|负责新建红冲单据界面所需服务|
|NewModifyCopyBillBlController|负责新建红冲并复制单据界面所需服务|
|SalesDetailsListBlController|负责销售明细表界面所需服务|

（3）模块内部类的接口规范  

BusinessConditionListBlController的接口规范  


|提供的服务（供接口）||
|:----|:----|
|BusinessConditionListBlController.getBills||
|语法|public BusinessConditionListVO getBills()|
|前置条件|用户查看经营情况表信息|
|后置条件|调用getBills方法|
|BusinessConditionListBlController.exportList||
|语法|public void exportList()|
|前置条件|用户导出经营情况表|
|后置条件|调用exportList方法|

|需要的服务（需接口）||
|:----|:----|
|服务|服务名|
|BusinessConditionBl|获得需要的单据之后处理单据信息的具体操作|
|GetBillBlService|读取单据的具体操作|

BusinessProcessListBlController的接口规范  


|提供的服务（供接口）||
|:----|:----|
|BusinessProcessListBlController.getBills||
|语法|public BusinessProcessListVO getBills()|
|前置条件|用户查看经营历程表|
|后置条件|调用getBills方法|
|BusinessProcessListBlController.exportList||
|语法|public void exportList()|
|前置条件|用户导出经营历程表|
|后置条件|调用exportList方法|

|需要的服务（需接口）||
|:----|:----|
|服务|服务名|
|GetBillBlService|读取单据的具体操作|

NewModifyBillBlController的接口规范  


|提供的服务（供接口）||
|:----|:----|
|NewModifyBillBlController. submitBill||
|语法|public void submitBill(InventoryWarningBillVO toSubmit)|
|前置条件|用户新建了一张库存报警单的红冲单据|
|后置条件|调用submitBill方法|
|NewModifyBillBlController. submitBill||
|语法|public void submitBill(InventoryOverBillVO toSubmit)|
|前置条件|用户新建了一张库存报溢单的红冲单据|
|后置条件|调用submitBill方法|
|NewModifyBillBlController. submitBill||
|语法|public void submitBill(InventoryLossBillVO toSubmit)|
|前置条件|用户新建了一张库存报损单的红冲单据|
|后置条件|调用submitBill方法|
|NewModifyBillBlController. submitBill||
|语法|public void submitBill(PurchaseBillVO toSubmit)|
|前置条件|用户新建了一张进货单的红冲单据|
|后置条件|调用submitBill方法|
|NewModifyBillBlController. submitBill||
|语法|public void submitBill(PurchaseReturnBillVO toSubmit)|
|前置条件|用户新建了一张进货退货单的红冲单据|
|后置条件|调用submitBill方法|
|NewModifyBillBlController. submitBill||
|语法|public void submitBill(SalesBillVO toSubmit)|
|前置条件|用户新建了一张销售单的红冲单据|
|后置条件|调用submitBill方法|
|NewModifyBillBlController. submitBill||
|语法|public void submitBill(SalesReturnBillVO toSubmit)|
|前置条件|用户新建了一张销售退货单的红冲单据|
|后置条件|调用submitBill方法|
|NewModifyBillBlController. submitBill||
|语法|public void submitBill(ReceiptBillVO toSubmit)|
|前置条件|用户新建了一张收款单的红冲单据|
|后置条件|调用submitBill方法|
|NewModifyBillBlController. submitBill||
|语法|public void submitBill(PaymentBillVO toSubmit)|
|前置条件|用户新建了一张付款单的红冲单据|
|后置条件|调用submitBill方法|
|NewModifyBillBlController. submitBill||
|语法|public void submitBill(CashExpenseBillVO toSubmit)|
|前置条件|用户新建了一张现金费用单的红冲单据|
|后置条件|调用submitBill方法|
|NewModifyBillBlController. submitBill||
|语法|public void submitBill(GiftBillVO toSubmit)|
|前置条件|用户新建了一张礼品赠送单的红冲单据|
|后置条件|调用submitBill方法|

|需要的服务（需接口）||
|:----|:----|
|服务|服务名|
|CreateBillBlService|新建单据的具体实现细节|

NewModifyCopyBillBlController的接口规范  


|提供的服务（供接口）||
|:----|:----|
|NewModifyCopyBillBlController. submitBill||
|语法|public void submitBill(InventoryWarningBillVO toSubmit)|
|前置条件|用户新建了一张库存报警单的红冲并复制单据|
|后置条件|调用submitBill方法|
|NewModifyCopyBillBlController. submitBill||
|语法|public void submitBill(InventoryOverBillVO toSubmit)|
|前置条件|用户新建了一张库存报溢单的红冲并复制单据|
|后置条件|调用submitBill方法|
|NewModifyCopyBillBlController. submitBill||
|语法|public void submitBill(InventoryLossBillVO toSubmit)|
|前置条件|用户新建了一张库存报损单的红冲并复制单据|
|后置条件|调用submitBill方法|
|NewModifyCopyBillBlController. submitBill||
|语法|public void submitBill(PurchaseBillVO toSubmit)|
|前置条件|用户新建了一张进货单的红冲并复制单据|
|后置条件|调用submitBill方法|
|NewModifyCopyBillBlController. submitBill||
|语法|public void submitBill(PurchaseReturnBillVO toSubmit)|
|前置条件|用户新建了一张进货退货单的红冲并复制单据|
|后置条件|调用submitBill方法|
|NewModifyCopyBillBlController. submitBill||
|语法|public void submitBill(SalesBillVO toSubmit)|
|前置条件|用户新建了一张销售单的红冲并复制单据|
|后置条件|调用submitBill方法|
|NewModifyCopyBillBlController. submitBill||
|语法|public void submitBill(SalesReturnBillVO toSubmit)|
|前置条件|用户新建了一张销售退货单的红冲并复制单据|
|后置条件|调用submitBill方法|
|NewModifyCopyBillBlController. submitBill||
|语法|public void submitBill(ReceiptBillVO toSubmit)|
|前置条件|用户新建了一张收款单的红冲并复制单据|
|后置条件|调用submitBill方法|
|NewModifyCopyBillBlController. submitBill||
|语法|public void submitBill(PaymentBillVO toSubmit)|
|前置条件|用户新建了一张付款单的红冲并复制单据|
|后置条件|调用submitBill方法|
|NewModifyCopyBillBlController. submitBill||
|语法|public void submitBill(CashExpenseBillVO toSubmit)|
|前置条件|用户新建了一张现金费用单的红冲并复制单据|
|后置条件|调用submitBill方法|
|NewModifyCopyBillBlController. submitBill||
|语法|public void submitBill(GiftBillVO toSubmit)|
|前置条件|用户新建了一张礼品赠送单的红冲并复制单据|
|后置条件|调用submitBill方法|

|需要的服务（需接口）||
|:----|:----|
|服务|服务名|
|CreateBillBlService|新建单据的具体实现细节|

SalesDetailsListBlController的接口  


|提供的服务（供接口）||
|:----|:----|
|SalesDetailsListBlController.getBills||
|语法|public SalesDetailsListVO getBills()|
|前置条件|用户查看销售明细表|
|后置条件|调用getBills方法|
|SalesDetailsListBlController.exportList||
|前置条件|用户导出销售明细表|
|后置条件|调用exportList方法|

|需要的服务（需接口）||
|:----|:----|
|服务|服务名|
|GetBillBlService|读取单据的具体操作|

（4）业务逻辑层的动态模型  
图X表明了连锁商店系统中，当用户进行查表操作时，查表操作业务逻辑处理的相关对象之间的协作。  
图X为listBl模块想要进行财务操作时候的状态图。  


####4.1.9、approveBillBl模块  
（1）模块概述        
approveBillBl模块承担的需求参见需求规格说明文档功能需求及非相关非功能需求。         
approveBillBl模块的职责及接口参见软件体系结构描述文档。        

（2）整体结构        
  根据体系结构的设计，我们将系统分为展示层,业务逻辑层，数据层。每一层之间为了增加灵活性，我们会添加接口。比如在展示层之间，我们添加 blService.approveBillService.ApproveBillService接口，业务逻辑层和数据层之间添加dataService.billService.BillService接口。    
  此外我们采用委托式的控制方法，通过approveBillBlController去实现blService.approveBillService接口，之后通过PassOrDenyBillService GetTBDBillsService     
  接口去调用billBl的方法来实现审批单据的功能。PassOrDenyBillService GetTBDBillsService是为了消除循环依赖而产生的接口。    

approveBillBl模块的设计如图所示。
![](详细设计%20总经理%20设计类图%20顺序图%20状态图/approvebl.png)    

approveBillBl模块各个类的职责如下表所示。      


|模块|职责|
| :--- | :--- |
|approveBillBlController|负责实现对应于总经理审批单据界面所需要的服务|
|||

（3）模块内部类的接口规范           
 
approveBillBlController的接口规范          


|提供的服务（供接口）||
| :--- | :--- |
|**approveBillBlController.getBillsList**||
|语法|public ArrayList<BillVO> getBillsList()|
|前置条件|总经理进入审批单据界面，开始一次审批活动|
|后置条件|在该次审批界面内得到需要审批的单据列表|
|**approveBillBlController.passBills**||
|语法|public boolean passBills(String billName, String billId)|
|前置条件|总经理已选择需要审批通过的单据，并确定通过|
|后置条件|通过该单据|
|**approveBillBlController.denyBills**||
|语法|public boolean denyBills(String billName, String billId)|
|前置条件|总经理已选择需要拒绝通过的单据，并确定拒绝通过|
|后置条件|拒绝通过该单据|
|||

|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
| GetTBDBillsService.getBillList(BillStateEnum billState)|得到需要审批的单据列表(传入参数为BillStateEnum.TBD)|
| GetTBDBillsService.getBillList(BillStateEnum billState, String billName)|得到*某一具体类型*未审批的单据列表(传入参数为BillStateEnum.TBD)|
| GetTBDBillsService.passBill(String billName, String billId)|通过某一个具体单据(billName为该单据种类，billId为该单据Id编号)|
| GetTBDBillsService.denyBill(String billName, String billId)|拒绝通过某一个具体单据(billName为该单据种类，billId为该单据Id编号)|
| GetTBDBillsService.processBill(String billName, String billId)|处理某一个具体单据的库存数据以及客户应收应付数据更新(billName为该单据种类，billId为该单据Id编号)|
|||

（4）业务逻辑层的动态模型       
图1
![](详细设计%20总经理%20设计类图%20顺序图%20状态图/approveBill顺序图.png)
表明了xx灯具企业管理系统中审批单据的顺序图。         
图2
![](详细设计%20总经理%20设计类图%20顺序图%20状态图/approveBill状态图.png)
表明了xx灯具企业管理系统中审批单据的状态图        

（5）业务逻辑层的设计原理      
利用委托式风格，每个界面需要访问的业务逻辑由各自的控制器委托给不同的BL操作。    
其他略。 


####4.1.10、adminBl模块  
（1）模块概述    
adminBl模块承担的需求参见需求规格说明文档功能需求及非相关非功能需求。     
adminBl模块的职责及接口参见软件体系结构描述文档。      
（2）整体结构       
根据体系结构的设计，我们将系统分为展示层,业务逻辑层，数据层。每一层之间为了增加灵活性，我们会添加接口。比如在展示层之间，我们添加 blService.adminBlService.AdminBlService接口，业务逻辑层和数据层之间添加dataService.userDataService.UserDataService接口。    
此外我们采用委托式的控制方法，通过AdminBlController去实现blService.adminBlService.AdminBlService接口.
之后通过AdminBl去通过dataService.userDataService.UserDataService完成操作。  

adminBl模块的设计如图所示。
![](详细设计%20总经理%20设计类图%20顺序图%20状态图/adminBl.png)        
adminBl模块各个类的职责如下表所示。       


|模块|职责|
| :--- | :--- |
|adminBlController|负责实现对应于管理员界面所需要的服务|
|adminBl|adminController的具体操作对象，提供用户的增删改服务，可以帮助完成界面所需要的功能|
（3）模块内部类的接口规范   

AdminBlController的接口规范       


|提供的服务（供接口）||
| :--- | :--- |
|**AdminBlController.getUser**||
|语法|public UserVO getUser( String userId)|
|前置条件|无|
|后置条件|根据用户Id得到某个用户的信息|
|**AdminBlController.addUser**||
|语法|public boolean addUser(UserVO user)|
|前置条件|管理员要增加某个用户信息|
|后置条件|根据输入的用户信息增加一个新的用户|
|**AdminBlController.deleteUser**||
|语法|public boolean deleteUser( String userId)|
|前置条件|管理员要删除某个用户|
|后置条件|根据用户Id删除某个用户|
|**AdminBlController.updateUser**||
|语法|public boolean updateUser(UserVO user)|
|前置条件|管理员要更新某个用户的信息|
|后置条件|根据输入的用户信息更新某个用户的个人信息|


|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
|AdminBl.getUser(String userId)|根据用户Id得到某个用户的信息|
|AdminBl.addUser(UserVO user)|根据输入的用户信息增加一个新的用户|
|AdminBl.deleteUser( String userId)|根据用户Id删除某个用户|
|AdminBl.updateUser(UserVO user)|根据输入的用户信息更新某个用户的个人信息|

AdminBl的接口规范           


|提供的服务（供接口）||
| :--- | :--- |
|**AdminBl.getUser**||
|语法|public UserVO getUser( String userId)|
|前置条件|无|
|后置条件|根据用户Id得到某个用户的信息|
|**AdminBl.addUser**||
|语法|public boolean addUser(UserVO user)|
|前置条件|管理员要增加某个用户信息|
|后置条件|根据输入的用户信息增加一个新的用户|
|**AdminBl.deleteUser**||
|语法|public boolean deleteUser( String userId)|
|前置条件|管理员要删除某个用户|
|后置条件|根据用户Id删除某个用户|
|**AdminBl.updateUser**||
|语法|public boolean updateUser(UserVO user)|
|前置条件|管理员要更新某个用户的信息|
|后置条件|根据输入的用户信息更新某个用户的个人信息|

|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|  
|UserDataService.getUser(String userId)|根据用户Id得到某个用户的信息|
|UserDataService.addUser(UserVO user)|根据输入的用户信息增加一个新的用户|
|UserDataService.deleteUser( String userId)|根据用户Id删除某个用户|  
|UserDataService.updateUser(UserVO user)|根据输入的用户信息更新某个用户的个人信息|

（4）业务逻辑层的动态模型    
图1表明了xx灯具企业管理系统中管理员增加，删除，更新，查找用户的顺序图
![](详细设计%20总经理%20设计类图%20顺序图%20状态图/admin顺序图.png)     
图2表明了xx灯具企业管理系统中管理员增加，删除，更新，查找用户的状态图      
![](详细设计%20总经理%20设计类图%20顺序图%20状态图/admin状态图.png)

（5）业务逻辑层的设计原理    
利用委托式风格，每个界面需要访问的业务逻辑由各自的控制器委托给不同的领域对象。   
其他略。  


####4.1.11、promotionBl模块   
（1）模块概述    
promotionBl模块承担的需求参见需求规格说明文档功能需求及非相关非功能需求。     
promotionBl模块的职责及接口参见软件体系结构描述文档。    
（2）整体结构   
根据体系结构的设计，我们将系统分为展示层,业务逻辑层，数据层。每一层之间为了增加灵活性，我们会添加接口。比如在展示层之间，我们添加 blService.promotionBlService.PromotionBlService接口，业务逻辑层和数据层之间添加dataService.promotionDataService.PromotionDataService接口。    
此外我们采用委托式的控制方法，通过PromotionBlController去实现blService.promotionBlService.PromotionBlService接口.
之后通过PromotionBl去通过dataService.promotionDataService.PromotionDataService完成操作。      

promotionBl模块的设计如图所示。
![](详细设计%20总经理%20设计类图%20顺序图%20状态图/promotionbl.png)  
promotionBl模块各个类的职责如下表所示。    


|模块|职责|
| :--- | :--- |    
|PromotionBlController|负责实现对应于促销策略界面所需要的服务|
|PromotionBl|PromotionController的具体操作对象，提供促销策略的查看，制定，删除服务，可以帮助完成促销界面所需要的功能|
（3）模块内部类的接口规范     

PromotionBlController的接口规范      


|提供的服务（供接口）||
| :--- | :--- |
|**PromotionBlController.getUserStrategyList**||
|语法|public ArrayList<UserStrategyVO> getUserStrategyList() |
|前置条件|已创建一个PromotionBl对象|
|后置条件|得到所有的现存的用户促销策略|
|**PromotionBlController.getTotalStrategyList**||
|语法|已创建一个PromotionBl对象|
|前置条件|public ArrayList<TotalStrategyVO> getTotalStrategyList() |
|后置条件|得到所有的现存的总价促销策略|
|**PromotionBlController.getComoboStrategyList**||
|语法|public ArrayList<ComboStrategyVO> getComoboStrategyList() |
|前置条件|已创建一个PromotionBl对象|
|后置条件|得到所有的现存的组合促销策略|
|**PromotionBlController.deleteStrategy**||
|语法|public boolean deleteStrategy(String strategyType, String strategyId) |
|前置条件|已创建一个PromotionBl对象，并且输入合理(促销策略种类有UserStrategy，TotalStrategy，ComboStrategy三种。Id符合促销策略Id规范)|
|后置条件|根据单据种类和Id删除某个具体单据|
|**PromotionBlController.addUserStrategy**||
|语法|public boolean addUserStrategy(UserStrategyVO strategy) |
|前置条件|已创建一个PromotionBl对象|
|后置条件|根据输入的用户促销策略内容新增一个用户促销策略|
|**PromotionBlController.addTotalStrategy**||
|语法|public boolean addTotalStrategy(TotalStrategyVO strategy) |
|前置条件|已创建一个PromotionBl对象|
|后置条件|根据输入的总价促销策略内容新增一个总价促销策略|
|**PromotionBlController.addComoboStrategy**||
|语法|public boolean addComoboStrategy(ComboStrategyVO strategy) |
|前置条件|已创建一个PromotionBl对象|
|后置条件|根据输入的组合促销策略内容新增一个组合促销策略|
|||

|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
|PromotionBl.getUserStrategyList|得到所有的现存的用户促销策略|
|PromotionBl.getTotalStrategyList|得到所有的现存的总价促销策略|
|PromotionBl.getComoboStrategyList|得到所有的现存的组合促销策略|
|PromotionBl.deleteStrategy(String strategyType, String strategyId)|根据单据种类和Id删除某个具体单据|
|PromotionBl.addUserStrategy(UserStrategyVO strategy)|根据输入的用户促销策略内容新增一个用户促销策略|
|PromotionBl.addTotalStrategy(TotalStrategyVO strategy)|根据输入的总价促销策略内容新增一个总价促销策略|
|PromotionBl.addComoboStrategy(ComboStrategyVO strategy)|根据输入的组合促销策略内容新增一个组合促销策略|

PromotionBl的接口规范      


|提供的服务（供接口）||
| :--- | :--- |
|**PromotionBl.getUserStrategyList**||
|语法|public ArrayList<UserStrategyVO> getUserStrategyList() |
|前置条件|已创建一个PromotionBl对象|
|后置条件|得到所有的现存的用户促销策略|
|**PromotionBl.getTotalStrategyList**||
|语法|已创建一个PromotionBl对象|
|前置条件|public ArrayList<TotalStrategyVO> getTotalStrategyList() |
|后置条件|得到所有的现存的总价促销策略|
|**PromotionBl.getComoboStrategyList**||
|语法|public ArrayList<ComboStrategyVO> getComoboStrategyList() |
|前置条件|已创建一个PromotionBl对象|
|后置条件|得到所有的现存的组合促销策略|
|**PromotionBl.deleteStrategy**||
|语法|public boolean deleteStrategy(String strategyType, String strategyId) |
|前置条件|已创建一个PromotionBl对象，并且输入合理(促销策略种类有UserStrategy，TotalStrategy，ComboStrategy三种。Id符合促销策略Id规范)|
|后置条件|根据单据种类和Id删除某个具体单据|
|**PromotionBl.addUserStrategy**||
|语法|public boolean addUserStrategy(UserStrategyVO strategy) |
|前置条件|已创建一个PromotionBl对象|
|后置条件|根据输入的用户促销策略内容新增一个用户促销策略|
|**PromotionBl.addTotalStrategy**||
|语法|public boolean addTotalStrategy(TotalStrategyVO strategy) |
|前置条件|已创建一个PromotionBl对象|
|后置条件|根据输入的总价促销策略内容新增一个总价促销策略|
|**PromotionBl.addComoboStrategy**||
|语法|public boolean addComoboStrategy(ComboStrategyVO strategy) |
|前置条件|已创建一个PromotionBl对象|
|后置条件|根据输入的组合促销策略内容新增一个组合促销策略|
|||
|**服务名**|**服务**|

|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
|PromotionDataService.getUserStrategyList|得到所有的现存的用户促销策略|
|PromotionDataService.getTotalStrategyList|得到所有的现存的总价促销策略|
|PromotionDataService.getComoboStrategyList|得到所有的现存的组合促销策略|
|PromotionDataService.deleteStrategy(String strategyType, String strategyId)|根据单据种类和Id删除某个具体单据|
|PromotionDataService.addUserStrategy(UserStrategyPO strategy)|根据输入的用户促销策略内容新增一个用户促销策略|
|PromotionDataService.addTotalStrategy(TotalStrategyPO strategy)|根据输入的总价促销策略内容新增一个总价促销策略|
|PromotionDataService.addComoboStrategy(ComboStrategyPO strategy)|根据输入的组合促销策略内容新增一个组合促销策略|


（4）业务逻辑层的动态模型       
图1表明了xx灯具企业管理系统中制定，删除，更新促销删除策略的顺序图      
![](详细设计%20总经理%20设计类图%20顺序图%20状态图/promotion顺序图.png)
图2表明了xx灯具企业管理系统中制定，删除，更新促销删除策略的状态图        
![](详细设计%20总经理%20设计类图%20顺序图%20状态图/promotion状态图.png)
（5）业务逻辑层的设计原理    
利用委托式风格，每个界面需要访问的业务逻辑由各自的控制器委托给不同的领域对象。       
其他略。      


####4.1.12、billBl模块   
（1）模块概述    
billBl模块承担的需求参见需求规格说明文档功能需求及非相关非功能需求。     
billBl模块的职责及接口参见软件体系结构描述文档。    
（2）整体结构   
根据体系结构的设计，我们将系统分为展示层,业务逻辑层，数据层。每一层之间为了增加灵活性，我们会添加接口。业务逻辑层和数据层之间添加dataService.billDataService.BillDataService接口。billBl为一个比较基础的单据处理类，负责为库存管理人员，销售人员，财务人员提供查看单据，创建单据的服务  
为总经理提供审批单据的服务。     

billBl模块的设计如图所示。  
![](详细设计%20总经理%20设计类图%20顺序图%20状态图/billBl.png)
billBl模块各个类的职责如下表所示。    


|模块|职责|
| :--- | :--- |    
|CreateBillBl|负责实现创建单据所需要的服务|
|GetBillBl|负责实现得到单据所需要的服务|
|ProcessBillBl|负责实现通过单据审批后库存数量以及客户应收应付数据的更新所需要的服务|

（3）模块内部类的接口规范     

CreateBillBl的接口规范      


|提供的服务（供接口）||
| :--- | :--- |
|**CreateBillBl.createGiftBill**||
|语法|public boolean createGiftBill(GiftBillVO bill)|
|前置条件||
|后置条件|创建一张新的库存赠送单|
|**CreateBillBl.createInventoryOverBill**||
|语法|public boolean createInventoryOverBill(InventoryOverBillVO bill)|
|前置条件||
|后置条件|创建一张新的库存报溢单|
|**CreateBillBl.createInventoryOverBill**||
|语法|public boolean createInventoryWarningBill(InventoryWarningBillVO bill)|
|前置条件||
|后置条件|创建一张新的库存报警单|
|**CreateBillBl.createInventoryLossBill**||
|语法|public boolean createInventoryLossBill(InventoryLossBillVO bill)|
|前置条件||
|后置条件|创建一张新的库存报损单|
|**CreateBillBl.createPurchaseBill**||
|语法|public boolean createPurchaseBill(PurchaseBillVO bill)|
|前置条件||
|后置条件|创建一张新的进货单|
|**CreateBillBl.createPurchaseReturnBill**||
|语法|public boolean createPurchaseReturnBill(PurchaseReturnBillVO bill)|
|前置条件||
|后置条件|创建一张新的进货退货单|
|**CreateBillBl.createSalesBill**||
|语法|public boolean createSalesBill(SalesBillVO bill)|
|前置条件||
|后置条件|创建一张新的销售单|
|**CreateBillBl.createSalesReturnBill**||
|语法|public boolean createSalesReturnBill(SalesReturnBillVO bill)|
|前置条件||
|后置条件|创建一张新的销售退货单|
|**CreateBillBl.createReceiptBill**||
|语法|public boolean createReceiptBill(ReceiptBillVO bill)|
|前置条件||
|后置条件|创建一张新的收款单|
|**CreateBillBl.createPaymentBill**||
|语法|public boolean createPaymentBill(PaymentBillVO bill)|
|前置条件||
|后置条件|创建一张新的付款单|
|**CreateBillBl.createCashBill**||
|语法|public boolean createCashBill(CashExpenseBillVO bill)|
|前置条件||
|后置条件|创建一张新的现金费用单|


|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
| billDataService.CreateBillDataService.createGiftBill(GiftBillPO)  |创建一张新的库存赠送单|
| billDataService.CreateBillDataService.createInventoryOverBill(InventoryOverBillPO)  |创建一张新的库存报溢单|
| billDataService.CreateBillDataService.createInventoryWarningBill(InventoryWarningBillPO)  |创建一张新的库存报警单|
| billDataService.CreateBillDataService.createInventoryLossBill(InventoryLossBillPO)  |创建一张新的库存报损单|
| billDataService.CreateBillDataService.createPurchaseBill(PurchaseBillPO)  |创建一张新的进货单|
| billDataService.CreateBillDataService.createPurchaseReturnBill(PurchaseReturnBillPO)  |创建一张新的进货退货单|
| billDataService.CreateBillDataService.createSalesBill(SalesBillPO)  |创建一张新的销售单|
| billDataService.CreateBillDataService.createSalesReturnBill(SalesReturnBillPO)  |创建一张新的销售退货单|
| billDataService.CreateBillDataService.createReceiptBill(ReceiptBillPO)  |创建一张新的收款单|
| billDataService.CreateBillDataService.createPaymentBill(PaymentBillPO)  |创建一张新的付款单|
| billDataService.CreateBillDataService.createcashExpenseBill(CashExpenseBillPO)  |创建一张新的现金费用单|

GetBillBl的接口规范       


|提供的服务（供接口）||
| :--- | :--- |
|**GetBill.getBillByNameAndId**||
|语法|public BillVO getBillByNameAndId(String billName,String billId)|
|前置条件||
|后置条件|根据单据种类和单据的Id得到单据|
|**GetBill.getBillListByState**||
|语法|public ArrayList<BillVO> getBillListByState(String billState)|
|前置条件||
|后置条件|根据单据的种类得到单据|
|**GetBill.getBillListByStateAndName**||
|语法|public ArrayList<BillVO> getBillListByStateAndName(String billState)|
|前置条件||
|后置条件|根据单据的种类和名称得到单据|
|**GetBill.getTBDBillsListByCreater**||
|语法|public ArrayList<BillVO> getTBDBillsListByCreater(String userName,String userId,UserPositionEnum userRole)|
|前置条件||
|后置条件|根据提交人的姓名和Id得到单据|
|**GetBill.getToDoBillsListByExecutor**||
|语法|public ArrayList<BillVO> getToDoBillsListByExecutor(String userName,String userId,UserPositionEnum userRole)|
|前置条件||
|后置条件|根据操作员的姓名和Id得到单据|
|**GetBill.getDeniedBillsListByCreater**||
|语法|public ArrayList<BillVO> getDeniedBillsListByCreater(String userName,String userId,UserPositionEnum userRole)|
|前置条件||
|后置条件|根据提交人的姓名和Id得到单据|
|**GetBill.getDoneBillsListByExecutor**||
|语法|public ArrayList<BillVO> getDoneBillsListByExecutor(String userName,String userId,UserPositionEnum userRole)|
|前置条件||
|后置条件|根据操作员的姓名和Id得到单据|

|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
| billDataService.GetBillDataService.getBillByNameAndId(String billName,String billId)  |根据单据种类和单据的Id得到单据|
| billDataService.GetBillDataService.getBillListByState(String billState)  |根据单据的种类得到单据|
| billDataService.GetBillDataService.getBillListByStateAndName(String billState,String billName)  |根据提交人的姓名和Id得到单据|
| billDataService.GetBillDataService.getTBDBillsListByCreater(String userName,String userId,UserPositionEnum userRole)  |根据操作员的姓名和Id得到未审批单据|
| billDataService.GetBillDataService.getToDoBillsListByExecutor(String userName,String userId,UserPositionEnum userRole)  |根据操作员的姓名和Id得到将要完成单据|
| billDataService.GetBillDataService.getDeniedBillsListByCreater(String userName,String userId,UserPositionEnum userRole)  |根据操作员的姓名和Id得到被拒绝单据|
| billDataService.GetBillDataService.getDoneBillsListByExecutor(String userName,String userId,UserPositionEnum userRole)  |根据操作员的姓名和Id得到已完成单据|

ProcessBill的接口规范       


|提供的服务（供接口）||
| :--- | :--- |
|**ProcessBill.passBill**||
|语法| public boolean passBill(String  billName, String billId)|
|前置条件|该单据为TBD(未审批)状态|
|后置条件|根据单据名称和Id通过一个单据|
|**ProcessBill.denyBill**||
|语法|public boolean denyBill(String  billName, String billId)|
|前置条件|该单据为TBD(未审批)状态|
|后置条件|根据单据名称和Id拒绝一个单据|
|**ProcessBill.doneBill**||
|语法|public boolean doneBill(String  billName, String billId)|
|前置条件|该单据为TODO(待完成)状态|
|后置条件|根据单据名称和Id完成一个单据|
|**ProcessBill.hideBill**||
|语法| public boolean hideBill(String  billName, String billId)|
|前置条件|该单据为Done(已完成)或者Denied(被拒绝)状态|
|后置条件|根据单据名称和Id隐藏（假性删除）一个单据|
|**ProcessBill.processBill**||
|语法| public boolean processBill(String billName, String billId)|
|前置条件|该单据为Passed(审批通过)状态|
|后置条件|根据单据名称和Id完成一个单据带来的库存数量和客户应收应付数据的更新|


|需要的服务（需接口）||
| :--- | :--- |
|**服务名**|**服务**|
|dataService.billDataService.changeBillState(String billName,String billId,BillStateEnum from,BillStateEnum to)|根据单据类型和Id改变一个单据的状态|
|dataService.billDataService.changeBillState||
|dataService.billDataService.changeBillState||



##5、依赖视角  
下图
![](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/体系结构设计2作业图/包图.png)
是客户端和服务器端各自的包之间的依赖关系。  

##6、耦合的度量   



|类名|CBO|DAC|NOC|DIT|
| :--- | :--- | :--- | :--- | :--- |
|GoodsClassificationController| 5|5|0|1|
||调用其它类5，被其他类调用0|ClassificationTreeVO、ClassificationVO、GoodsVO、ClassificationPO|||
|ClassificationTree| 2|2|0|1|
||调用其它类1，被其他类调用1（到底goodsInfor有没有调呢，还是直接从goodsInforUi层调GoodsClassificationBl层的controller里的getClassificationTree呢）|ClassificationTreeVO、ClassificationPO|||
|ID| 3|1|0|1|
||调用其它类1，被其他类调用2|ClassificationPO|||
|UpdateClassificationStructure| 2|2|0|1|
||调用其它类1，被其他类调用1|ClassificationPO、ClassificationVO|||
|UpdateClassificationOfGoods| 5|3|0|1|
||调用其它类2，被其他类调用3|ClassificationPO、GoodsVO、GoodsPO|||
|AddGoodsController| 4|4|0|1|
||调用其它类4，被其他类调用0|GoodsPO、GoodsVO、StockInOutPO、StockInOutVO|||
|DeleteGoodsController| 5|4|0|1|
||调用其它类5，被其他类调用0|GoodsPO、GoodsVO、StockInOutPO、StockInOutVO|||
|WarningValue| 1|1|0|1|
||调用其它类1，被其他类调用1|StockInOutPO|||
|UpdateGoodsAfterStock| 3|2|0|1|
||调用其它类1，被其他类调用2|StockInOutVO、GoodsPO|||
|GoodsInforController| 2|3|0|1|
||调用其它类2，被其他类调用0|GoodsVO、GoodsPO、GoodsListVO|||
|StockCheckController| 1|1|0|1|
||调用其它类1，被其他类调用0|StockCheckSheetVO|||
|InventoryCheckController| 1|1|0|1|
||调用其它类1，被其他类调用0|InventoryCheckSheetVO|||
|CheckSheet| 4|2|0|1|
||调用其它类2，被其他类调用2|StockInOutPO、GoodsPO|||
|ActualInventoryCheckController| 1|1|0|1|
||调用其它类1，被其他类调用0|GoodsPO|||
|SaveBillController| 1|3|0|1|
||调用其它类1，被其他类调用0|InventoryWarningBillVO、InventoryOverBillVO、InventoryLossBillVO|||
| ViewSalesmanBillController | 2 | 4 | 0 | 1 |
| | 调用其它类1，被其他类调用1 | PurchaseReturnBillVO SalesBillVO  PurchaseBillVO SalesReturnBillVO  | | |
| LogBlController | 3 | 0 | 0 | 1 |
| | 调用其它类3 | | | |
| LogBl | 3 | 0 | 0 | 1 |
| | 被其他类调用3 | | | |
| CustomerBlController | 6 | 1 | 0 | 1 |
| | 调用其它类5，被其他类调用1 | CustomerVO | | |
| CustomerBl | 5 | 1 | 0 | 1 |
| | 被其他类调用5 | CustomerVO | | |
| ModifyCustomerMoneyService | 2 | 0 | 0 | 1 |
| | 调用其它类1，被其他类调用1 | | | |
| SalesBlController | 5 | 4 | 0 | 1 |
| | 调用其它类5 | PurchaseReturnBillVO SalesBillVO  PurchaseBillVO SalesReturnBillVO | | |
| SalesBl | 5 | 4 | 0 | 1 |
| | 被其他类调用5 | PurchaseReturnBillVO SalesBillVO PurchaseBillVO SalesReturnBillVO | | |
|FinancialStaffBillStateBlController|4|0|0|1|
||调用其他类4，被其他类调用0||||
|SalesmanBillStateBlController|1|0|0|1|
||调用其他类1，被其他类调用0||||
|WareKeeperBillStateBlController|3|0|0|1|
||调用其他类3，被其他类调用0||||
|ViewFinanceStaffBillBlController|3|3|0|1|
||调用其他类3，被其他类调用0|PaymentBillVO，ReceiptBillVO，CashExpenseBillVO|||
|BankAccountBlController|5|1|0|1|
||调用其他类5，被其他类调用0|BankAccountVO|||
|BankAccountBl|10|2|0|1|
||调用其他类5，被其他类调用5|BankAccountVO，BankAccountPO|||
|InOutBlController|5|3|0|1|
||调用其他类5，被其他类调用5|InitialInfoVO，InOutDetailsVO，SingleEntryVO|||
|InOutBl|10|6|||
||调用其他类5，被其他类调用5|InitialInfoVO，InOutDetailsVO，SingleEntryVO，InitialInfoPO，InOutDetailsPO，SingleEntryPO|||
|NewFinanceBillsBlController|3|3|0|1|
||调用其他类3，被其他类调用0|CashExpenseBillVO，PaymentBillVO，ReceiptBillVO|||
|NewFinanceBillsBl|6|6|0|1|
||调用其他类3，被其他类调用3|CashExpenseBillVO，PaymentBillVO，ReceiptBillVO，CashExpenseBillPO，PaymentBillPO，ReceiptBillPO|||
|BusinessConditionListBlController|1|1|0|1|
||调用其他类1，被其他类调用0|BusinessConditionListVO|||
|BusinessConditionListBl|2|2|0|1|
||调用其他类1，被其他类调用1|BusinessConditionListVO，BusinessConditionListPO|||
|BusinessProcessListBlController|1|1|0|1|
||调用其他类1，被其他类调用0|BusinessProcessListVO|||
|BusinessConditionListBl|2|2|0|1|
||调用其他类1，被其他类调用1|BusinessProcessListVO，BusinessProcessListPO|||
|NewModifyBillBlController|11|11|0|1|
||调用其他类11，被其他类调用0|InventoryWarningBillVO，InventoryOverBillVO，InventoryLossBillVO，PurchaseBillVO，PurchaseReturnBillVO，SalesBillVO，SalesReturnBillVO，ReceiptBillVO，PaymentBillVO，CashExpenseBillVO，GiftBillVO|||
|NewModifyBillBl|22|22|0|1|
||调用其他类11，被其他类调用11|InventoryWarningBillVO，InventoryOverBillVO，InventoryLossBillVO，PurchaseBillVO，PurchaseReturnBillVO，SalesBillVO，SalesReturnBillVO，ReceiptBillVO，PaymentBillVO，CashExpenseBillVO，GiftBillVO，InventoryWarningBillPO，InventoryOverBillPO，InventoryLossBillPO，PurchaseBillPO，PurchaseReturnBillPO，SalesBillPO，SalesReturnBillPO，ReceiptBillPO，PaymentBillPO，CashExpenseBillPO，GiftBillPO|||
|NewModifyCopyBillBlController|11|11|0|1|
||调用其他类11，被其他类调用0|InventoryWarningBillVO，InventoryOverBillVO，InventoryLossBillVO，PurchaseBillVO，PurchaseReturnBillVO，SalesBillVO，SalesReturnBillVO，ReceiptBillVO，PaymentBillVO，CashExpenseBillVO，GiftBillVO|||
|NewModifyCopyBillBl|22|22|0|1|
||调用其他类11，被其他类调用11|InventoryWarningBillVO，InventoryOverBillVO，InventoryLossBillVO，PurchaseBillVO，PurchaseReturnBillVO，SalesBillVO，SalesReturnBillVO，ReceiptBillVO，PaymentBillVO，CashExpenseBillVO，GiftBillVO，InventoryWarningBillPO，InventoryOverBillPO，InventoryLossBillPO，PurchaseBillPO，PurchaseReturnBillPO，SalesBillPO，SalesReturnBillPO，ReceiptBillPO，PaymentBillPO，CashExpenseBillPO，GiftBillPO|||
|SalesDetailsListBlController|1|1|0|1|
||调用其他类1，被其他类调用0|SalesDetailsListVO|||
|SalesDetailsListBl|2|2|0|1|
||调用其他类1，被其他类调用1|SalesDetailsListVO，SalesDetailsListPO|||
|AdminBl|8|1|0|1|
|       |调用其他类4，被其他类调用4|UserDataService|||
|AdminBlController|4|1|0|1|
|       |调用其他类4，被其他类调用0|AdminBl|||
|ApproveBillBlController|5|2|0|1|
|       |调用其他类2，被其他类调用3|GetBillBl,ProcessBillBl|||
|CreateBillBl|22|1|0|1|
|       |调用其他类11，被其他类调用11|CreateBillDataService|||
|GetBillBl|14|1|0|1|
|       |调用其他类7，被其他类调用7| GetBillDataService|||
|ProcessBillBl|6|1|0|1|
|       |调用其他类1，被其他类调用5| ProcessBillDataService|||
|PromotionBl|14|1|0|1|
|       |调用其他类7，被其他类调用7| PromotionDataService|||
|PromotionBlController|14|1|0|1|
|       |调用其他类7，被其他类调用7|PromotionBl|||









