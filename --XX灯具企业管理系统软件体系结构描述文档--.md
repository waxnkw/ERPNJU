------ 



#**XX灯具企业管理系统软件体系结构描述文档**  
##1、引言  
###1.1、编制目的  
本报告详细完成对xx灯具企业管理系统的概要设计，达到指导详细设计和开发的目的，同样实现和测试人员及用户的沟通。  
本报告面向开发人员、测试人员及最终用户而编写，是了解系统的导航。  
###1.2、词汇表  
无  
###1.3、参考资料  
* 连锁商店管理系统（MSCS）软件体系结构描述文档  
##2、产品概述  
参考xx灯具企业管理系统用例文档和xx灯具企业管理系统软件需求规格说明中对产品的概括描述。  
##3、逻辑视角  
xx灯具企业管理系统中，选择了分层体系结构风格，将系统分为三层（展示层、业务逻辑层、数据层）能够很好的示意整个高层抽象。展示层包括GUI页面的实现，业务逻辑层包含业务逻辑处理的实现，数据层负责数据的持久化和访问。分层体系结构的逻辑视角和逻辑设计方案如图1
![图1](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/体系结构设计2作业图/图1%20参照体系结构风格的包图表达逻辑视角.png)
和图2
![图2](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/体系结构设计2作业图/图2%20软件体系结构逻辑设计方案.png).  
##4、组合视角  
###4.1、开发包图  
xx灯具企业管理系统的最终开发包设计如表1所示。  

表1 xx灯具企业管理系统的最终开发包设计  

| 开发（物理）包 | 依赖的其他开发包 |
| --- | --- |
| logUi | salesmanMainUi, wareKeeperMainUi, finacialStaffMainUi, managerMainUi, adminMainUi, logblService，界面类库包 |
| wareKeeperMainUi | commodityUi, billStateUi, 界面类库包|
| slaesmanMainUi | customerUi, salesUi,  billStateUi，界面类库包|
| financeStaffMainUi | financeUi, listUi, billStateUi, 界面类库包|
| managerMainUi | billStateUi, approveBillUi, listUi, promotionUi，界面类库包|
| adminMainUi | adminUi，界面类库包|
| adminUi | adminblService，界面类库包|
| commodityUi | commodityBlService，界面类库包|
| commodityBl | commodityDataService,billBlService,commodityDataService,vo,po|
| commodityBlService | commodityBl,Java RMI,vo|
| listUi | viewBillUi, listblService，，界面类库包|
| viewBillUi | viewBillBlService，界面类库包|
| billStateUi | billStateBlService, viewBillUi，界面类库包|
| approveBillUi | approveService, viewBillUi，界面类库包|
| financeUi | finaceBlService，界面类库包|
| salesUi | salesBlService，界面类库包|
| promotionUi | promotionblService, customerUi，界面类库包|
| customerUi | customerblService，界面类库包|
| logBl | userDataService, logBlService,vo,po |
| billBl | customerbl, commoditybl, billDataService,vo,po |
| viewBillBl | viewBillBlService,vo,po |
| viewBillBlService |JavaRMI,vo |
| approveBillBl | approveBillBlService, billBl ,vo,po|
| approveBillBlService |JavaRMI,vo |
| billStateBl | billStateBlService, billBl,vo,po |
| billStateBlService |JavaRMI,vo |
| financeBl | financeDataService, finaceBlService,vo,po |
| financeBlService |JavaRMI,vo |
| salesBl | commodityBl, salesBlService,vo,po |
| salesBlService |JavaRMI,vo |
| customerBl | customerDataService, customerBlService,vo,po |
| customerBlService | JavaRMI,vo  |
| promotionBl | commodityBl, promotionBlService ,vo,po|
| promotionBlService | JavaRMI,vo |
| adminBl | adminBlService, userDataService,vo,po |
| adminBlService | JavaRMI,vo |
| userData | userDataService |
| userDataService | po |
| commodityData | commodityDataService |
| commodityDataService | po |
| billData | billDataService |
| billDataService | po |
| financeData | financeDataService |
| financeDataService |po|
| customerData | customerDataService |
| customerDataService |po|
| promotionData |promotionDataService |
| promotionDataService |po|
|vo||
|po||
|Java RMI||

xx灯具企业管理系统客户端和服务器端开发包如图3和图4
![图3](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/体系结构设计2作业图/包图.png)
所示。  


###4.2 运行时进程  
 在进销存管理系统中，会有多个客户端进程和一个服务器进程，其进程图如图5
 ![图5](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/体系结构设计2作业图/图5%20进程图+图6%20部署图.png)
 所示。结合部署图，客户端进程是在客户端机器上运行，服务器端进程是在服务器端机器上运行。  
 
###4.3 物理部署  
 进销存管理系统中客户端构件是放在客户端机器上，服务器端构件是放在服务器端机器上。在客户端节点上，还要部署RMIStub构件。由于Java RMI构件属于JDK 6.0的一部分。所以，在系统JDK环境已经设置好的情况下，不需要再独立部署。部署图如图6
 ![图6](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/体系结构设计2作业图/图5%20进程图+图6%20部署图.png)
 
 所示。  
 
##5. 接口视角  
###5.1 模块的职责  
客户端模块和服务器端模块视图分别如图7
![图7](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/体系结构设计2作业图/图7%20客户端模块视图+图8%20服务器端模块视图.png)
和图8
![图8](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/体系结构设计2作业图/图7%20客户端模块视图+图8%20服务器端模块视图.png)
所示。客户端各层和服务器端各层的职责分别如表2和表3所示。  

表2 客户端各层的职责  

| 层 | 职责 |
| --- | --- |
| 启动模块 | 负责初始化网络通信机制，启动用户界面 |
| 用户界面层 | 基于窗口的进销存管理系统界面 |
| 业务逻辑层 | 对于用户界面的输入进行响应并进行业务处理逻辑 |
| 客户端网络模块 | 利用Java RMI机制查找RMI服务 |

表3 服务器端各层的职责  

| 层 | 职责 |
| --- | --- |
| 启动模块 | 负责初始化网络通信机制，启动用户界面 |
| 数据层 | 负责数据的持久化及数据访问接口 |
| 服务器端网络模块 | 利用Java RMI机制开启RMI服务，注册RMI服务 |

每一层只是使用下方直接接触的层。层与层之间仅仅是通过接口的调用来完成的。层之间调用的接口如表4所示。

表4  层之间调用的接口

|接口|服务调用方|服务提供方|
| :--- | :--- | :-- |
|commodityBlService；viewBillBlService；approveBillBlService；billStateBlService；financeBlService；salesBlService；customerBlService；promotionBlService；adminBlService ；|客户端展示层|服务器端业务逻辑层|
| userDataService；commodityDataService ；billDataService ；financeDataService ；customerDataService；promotionDataService；|服务器端业务逻辑层|服务器端数据层|

借用销售用例来说明层之间的调用，如图9
![图9](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/体系结构设计2作业图/图9%20客户管理层之间调用的接口.png)
所示。每一层之间都是由上层依赖了一个接口（需接口），而下层实现这个接口（供接口）。SalesBLService提供了Sales界面所需要的所有业务逻辑功能。SalesDataService提供了对数据的增、删、改、查等操作。这样的实现就大大降低了层与层之间的耦合。  


-------------  

##5.2 用户界面分层分解  
根据需求，系统存在17个界面：登录界面、仓库管理员主界面、销售人员主界面、财务人员主界面、总经理主界面、系统管理员主界面、库存管理界面、查看单据界面、新建单据界面、审批单据界面、单据状态界面、查表界面、财务处理界面、销售界面、促销界面、客户管理界面、系统管理界面。界面跳转如图10
![图10](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/体系结构设计2作业图/界面跳转图.png)
所示。    

服务器端和客户端的用户界面设计接口是一致的，只是具体的界面不一样。用户界面类如图11
![图11](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/体系结构设计2作业图/用户界面类.png)
所示。   


####**5.2.1、模块的职责**  

|模块|职责|
| :--- | :-- |
|wareKeeperMainUi|显示仓库管理初始界面，以及负责仓库管理各功能主界面切换|
|wareKeeperMainUi.WareKeeperMainUi|负责显示仓库管理员的初始界面，为仓库管理各功能主界面的入口|
|commodityUi|负责仓库管理各功能的所有界面的显示和跳转|
|commodityUi.GoodsClassificationUi|负责商品分类管理功能的各界面显示与跳转|
|commodityUi.AddGoodsUi|负责增加商品功能的各界面显示与跳转|
|commodityUi.DeleteGoodsUi|负责减少商品功能的各界面显示与跳转|
|commodityUi.GoodsInforManagementUi|负责商品信息的查询与修改功能的各界面显示与跳转|
|commodityUi.StockCheckUi|负责库存审查功能的各界面显示与跳转|
|commodityUi.InventoryCheckUi|负责库存查看功能的各界面显示与跳转|
|commodityUi.ActualInventoryCheckUi|负责实际商品数量录入并出单功能的显示与跳转|
| logUi.loginUi | 负责登陆界面的显示和界面的跳转，登录成功后跳转至使用者工作相应界面 |
| logUi.registerUi | 负责用户注册界面的显示和界面的跳转，注册成功后跳转到登录界面 |
| salaesmanMainUi | 负责显示进货销售人员功能选择的界面，可跳转至进货销售人员制定单据界面、进货销售人员查看待审批单据界面、进货销售人员客户管理界面 |
| salesUi.initSalesUi | 负责显示进货销售人员制定单据的单据类型选择界面，可以跳转到新建进货单界面、新建进货退货单界面、新建出货单界面、新建出货退货单界面 |
| salesUi.newPurchaseUi | 负责显示进货销售人员新建供应商进货单的界面，可跳转到商品选择界面 |
| salesUi.newPurReturnUi | 负责显示进货销售人员新建供应商进货退货单的界面，可跳转到商品选择界面 |
| salesUi.newSaleUi | 负责显示进货销售人员新建销售商出货单的界面，可跳转到商品选择界面 |
| salesUi.newSalReturnUi | 负责显示进货销售人员新建销售商出货退货单的界面，可跳转到商品选择界面 |
| salesUi.commoditySelectUi | 负责显示已有商品的名称列表，可选择列表中商品或添加商品并跳转到新建进货单界面、新建进货退货单界面、新建出货单界面、新建出货退货单界面 |
| initCustomerUi | 负责显示进货销售人员进行客户管理任务的操作选择界面，可以跳转到增加客户界面、删除客户界面、修改客户信息界面、查询客户信息界面 |
| customerUi.addCustomerUi | 负责显示进货销售人员增加客户的界面 |
| customerUi.delCustomerUi | 负责显示进货销售人员删除客户的界面 |
| customerUi.modCustomerUi | 负责显示进货销售人员修改客户信息的界面 |
| customerUi.queryCustomerUi | 负责显示进货销售人员查询客户的界面，界面上显示的客户信息包括编号、分类（进货商、销售商）、级别（五级，一级普通用户，五级VIP客户）、姓名、电话、地址、邮编、电子邮箱、应收额度、应收、应付、默认业务员 |
| customerUi.verifyUi | 负责显示修改客户应收额度时的身份验证界面 |
|FinancialStaffMainUi|	负责显示财务人员所有工作的入口按钮和跳转，包括：财务人员账户管理、制定收付款单、制定现金费用单、查看销售明细表、查看经历历程表、红冲、红冲并复制、查看经营情况表、期初建账。|
|ViewReceiptBillUi|	负责显示收款单的具体信息，包括：单据编号，操作员，银行账户，条目清单，总额。其中条目清单包括：条目名，金额，备注。
|ViewPaymentBillUi|	负责显示付款单的具体信息，包括：单据编号，操作员，银行账户，条目清单，总额。其中条目清单包括：条目名，金额，备注。
|ViewCashExpenseBillUi|	负责显示现金费用单的具体信息，单据编号，操作员，银行账户，条目清单，总额。其中条目清单包括：条目名，金额，备注。
|ViewWareKeeperBillUi|查看仓库管理员制定的单据，包括库存报警单、库存报损单、库存报溢单|
|ViewSalesManBillUi|查看销售人员制定的单据|
| ViewPurWaitBillUi | 负责显示进货销售人员制定的等待审批的供应商进货单的信息 |
| ViewPurRetWaitBillUi | 负责显示进货销售人员制定的等待审批的供应商进货退货单的信息 |
|ViewSalWaitBillUi | 负责显示进货销售人员制定的等待审批的销售商出货单的信息 |
|ViewSalRetWaitBillUi | 负责显示进货销售人员制定的等待审批的销售商出货退货单的信息 |
|WareKeeperBillStateUi|	负责显示仓库管理员待制定的单据、待审核的单据、审核通过待处理的单据、未通过审核的单据。
|SalesmanBillStateUi|	负责显示销售进货人员待审核的单据、审核通过的单据、未通过审核的单据。
|FinancialStaffBillStateUi|	负责显示财务人员待制定的单据、待审核的单据、审核通过待处理的单据和未通过审核的单据。
|SalesDetailsListUi|	负责显示销售明细表。
|BusinessProcessListUi	|负责显示经营历程表。
|BusinessConditionListUi|	负责显示经营情况表。
|NewModifyBillUi|	负责显示新建红冲单据的界面
|NewModifyCopyBillUi|	负责显示新建红冲并复制单据的界面
|ViewBankAccountsUi|	负责显示银行账户列表，此界面上提供删除账户、修改账户名称的功能，并可天转至新建账户界面。
|NewBankAccountsUi|	负责显示新建账户功能，要求财务人员输入银行账户名称和余额，并可跳转至银行账户列表界面。
|NewReceiptBillUi|	负责显示新建收款单的界面。
|NewPaymentBillUi|	负责显示新建付款单的界面。
|NewCashExpenseBillUi|	负责显示新建现金费用单的界面
|ViewInOutListUi|	负责显示每年的账单列表，可查看每一套的明细，可查看一套账的期初信息，可跳转至期初建账界面。
|ViewInitialInformationUi|	负责显示某套账的期初信息，包括添加商品信息（商品分类，某一商品的名称，类别，型号，进价/售价，最近进价和最近售价留空），客户信息（客户分类，某一个客户的名称，联系方式等，应收应付(之前遗留)），银行账户信息（名称，余额）。
|ViewInOutDetailsUi	|负责显示每套账的明细。
|NewInOutUi|	负责显示新建一套账的界面，要求财务人员填写期初信息。
|managerMainUi|界面Ui,负责总经理的显示和总经理功能界面的跳转|
|adminMainUi|界面Ui,负责管理员的显示和总经理功能界面的跳转|
|adminUi|界面Ui,负责管理员的显示和总经理功能界面的跳转|
|approveBillUi |界面Ui,负责管理员的显示和总经理功能界面的跳转|
|  promotionUi |界面Ui,负责总经理促销策略页面的显示和跳转|


####**5.2.2、接口规范**  

wareKeeperMainUi.WareKeeperMainUi模块的接口规范  

*提供的服务（供接口）*  

|**WareKeeperMainUi.initwareKeeperMainUi**||
| :--- | :--- |
|语法|void initwareKeeperMainUi(String wareKeeperID,String wareKeeperName);|
|前置条件|仓库管理人员成功登录|
|后置条件|显示仓库管理初始界面（包括仓库管理员编号Label；仓库管理各功能按钮Button；仓库管理员待做单据Button；审核未通过单据Button；）|

*需要的服务（需接口）*  

|服务名|服务|
| :--- | :--- |
|billStateUi.WareKeeperBillStateUiService.wareKeeperBillStateUi()|显示和仓库管理相关的各种单据|
|commodityUi.GoodsClassificationUiService.initGoodsClassificationUi()|进入商品分类管理初始界面|
|commodityUi.AddGoodsUiService.initAddGoodsUi(Stage stage,String operatorName)|进入商品增加初始界面|
|commodityUi.DeleteGoodsUiService.initDeleteGoodsUi()|进入商品减少界面|
|commodityUi.GoodsInforManageMentUiService.initGoodsInforManagementUi()|进入商品信息管理界面|
|commodityUi.StockCheckUiService.initStockCheckUi()|进入库存审查初始界面|
|commodityUi.InventoryCheckUiService.initInventoryCheckUi()|进入库存盘点初始界面|
|commodityUi.ActualInventoryCheckUiService.initActualInventoryCheckUi()|进入商品分类管理初始界面|

commodityUi.GoodsClassificationUi模块的接口规范  

*提供的服务（供接口）*  

|**GoodsClassificationUi.initGoodsClassificationUi**||
| :--- | :--- |
|语法|void initGoodsClassificationUi();|
|前置条件|在仓库管理初始界面点击库存分类按钮|
|后置条件|显示库存分类初始界面（包括一个类别树（类别节点为按钮Button）；一个增加新类别按钮；一个返回按钮）|

*需要的服务（需接口）*  

|服务名|服务|
| :--- | :--- |
|commodityBlService.GoodsClassificationService.getClassificationTree()|提供类别树|
|commodityBlService.GoodsClassifcationService.ifClassificationExist(String classificationTag)|判断该类别标识是否已存在|
|commodityBlService.GoodsClassificationService.addNewClassification(String newClassificationName)|增加（无父类别的）新类别|
|commodityBlService.GoodsClassificationService.classificationInfor(String classificationNum)|获得类别信息|
|commodityBlService.GoodsClassificationService.addClassification(String classificationName) |增加（存在父类别的）新类别|
|commodityBlService.GoodsClassificationService.deleteClassification(String classificationNum)|删除类别|
|commodityBlService.DeleteGoodsService.obsoleteGoods(String goodsNum)|删除商品|
|commodityBlService.GoodsClassificationService.modifyClassificationOfGoods(GoodsVO vo)|修改商品所属类别|
|commodityBlService.GoodsClassificationService.modifyClassificationInfor(ClassificationVO vo)|修改类别信息|

commodityUi.AddGoodsUi模块的接口规范  

*提供的服务（供接口）*  

|**AddGoodsUi.initAddGoodsUi**||
| :--- | :--- |
|语法|void initAddGoodsUi(Stage stage,String operatorName);|
|前置条件|传入stage以及合法存在的操作者姓名|
|后置条件|显示增加商品初始界面（包括一个商品名称输入框；一个增加新商品Button；一个返回按钮Button）|

*需要的服务（需接口）*  

|服务名|服务|
| :--- | :--- |
|commodityBlService.AddGoodsService.addNewGoods(GoodsVO goodsVO,StockInOutVO stockVO)|增加新商品|
|commodityBlService.GoodsInforService.ifGoodsExist(String goodsID)|判断该编号的商品号是否存在|
|commodityBlService.GoodsInforService.ifGoodsExist(String goodsName,String goodsType)|判断该名称、型号的商品是否已存在|
|commodityBlService.GoodsClassifcationService.ifClassificationExist(String classificationTag)|判断该类别标识是否已存在|
|commodityBlService.AddGoodsService.add(sStockInOutVO vo)|增加商品|
|commodityBlService.GoodsInforService.goodsINfor(String goodsTag)|获得商品信息|

commodityUi.DeleteGoodsUi模块的接口规范  

*提供的服务（供接口）*  

|**DeleteGoodsUi.initDeleteGoodsUi**||
| :--- | :--- |
|语法|void initDeleteGoodsUi();|
|前置条件|在仓库管理初始界面点击减少商品按钮|
|后置条件|显示减少商品初始界面（一个输入商品标识框Panel，一个返回Button）|

*需要的服务（需接口）*  

|服务名|服务|
| :--- | :--- |
|commodityBlService.DeleteGoodsService.delete(StockInOutVO VO) |减少商品|
|commodityBlService.GoodsInforService.ifGoodsExist(String goodsTag)|判断该商品标识是否已存在|
|commodityBlService.GoodsInforService.goodsINfor(String goodsTag)|获得商品信息||
|commodityBlService.DeleteGoodsService.obsoleteGoods(String goodsNum)|彻底删除该商品|
|commodityBlService.DeleteGoodsService.compareToWarning(String goodsTag，int currentAmout)|将库存与警戒值比较，获得库存报警单|
|commodityBlService.SaveBillService.saveInventoryWarningBill(InventocyWarningBillVO  bill)|保存库存报警单|

commodityUi.GoodsInforManagementUi模块的接口规范  

*提供的服务（供接口）*  

|**GoodsInforManagementUi.initGoodsInforManagementUi**||
| :--- | :--- |
|语法|void initGoodsInforManagementUi();|
|前置条件|在仓库管理界面点击商品信息管理按钮|
|后置条件|显示商品信息管理初始界面（包括一个类别树，类别节点为button；一个商品标识输入Panel；一个返回Button）|

*需要的服务（需接口）*  

|服务名|服务|
| :--- | :--- |
|commodityBlService.GoodsClassificationService.getClassificationTree()|提供类别树|
|commodityBlService.GoodsClassificationService.classificationInfor(String classificationNum)|获得类别信息|
|commodityBlService.GoodsInforService.ifGoodsExist(String goodsTag)|判断该商品标识是否已存在|
|commodityBlService.GoodsInforService.goodsINfor(String goodsTag)|获得商品信息|
|commodityBlService.GoodsClassifcationService.ifClassificationExist(String classificationTag)|判断该类别标识是否已存在|
|commodityBlService.GoodsInforService.modifyGoodsInfor(GoodsVO vo)|修改商品信息|

commodityUi.StockCheckUi模块的接口规范  

*提供的服务（供接口）*  

|**StockCheckUi.initStockCheckUi**||
| :--- | :--- |
|语法|void initStockCheckUi();|
|前置条件|在库存管理初始界面点击库存审查按钮|
|后置条件|显示库存审查界面（包括一个时间选择Panel；一个返回Button）|

*需要的服务（需接口）*  

|服务名|服务|
| :--- | :--- |
|commodityBlService.StockCheckService.stockCheckSheet(String beginTime,String endTime)|获得某段时间内商品出入库情况|

commodityUi.InventoryCheckUi模块的接口规范  

*提供的服务（供接口）*  

|**InventoryCheckUi.initInventoryCheckUi**||
| :--- | :--- |
|语法|void initInventoryCheckUi();|
|前置条件|在库存管理初始界面点击库存盘点|
|后置条件|显示库存盘点界面（包括一个库存快照Panel；一个导出Button）|

*需要的服务（需接口）*  

|服务名|服务|
| :--- | :--- |
|commodityBlService.InventoryCheckService.inventoryCheckSheet(String date)|获得当天的库存快照|

commodityUi.ActualInventoryCheckUi模块的接口规范  

*提供的服务（供接口）*  

|**ActualInventoryCheckUi.initActualInventoryCheckUi**||
| :--- | :--- |
|语法|void initActualInventoryCheckUi();|
|前置条件|在仓库管理初始界面点击实际库存确认按钮|
|后置条件|显示实际库存确认初始界面（包括一个商品标识输入Panel）|

*需要的服务（需接口）*  

|服务名|服务|
| :--- | :--- |
|commodityBlService.GoodsInforService.ifGoodsExist(String goodsTag)|判断该商品标识是否已存在|
|commodityBlService.ActualInventoryCheckService.actualInventoryCheck(String goodsTag,int actualAmount)|判断实际库存是否和系统库存存在不同并出单（库存报溢单或库存报损单）|
|commodityBlService.SaveBillBlService.saveInventoryOverBill(InventoryOverBillVO bill)|保存库存报溢单|
|commodityBlService.SaveBillBlService.saveInventoryLossBill(InventoryLossBillVO bill)|保存库存报损单|

logUi.loginUi模块的接口规范  

*提供的服务（供接口）*  

| **logUi.loginUi** |  |
| :--- | :--- |
| 语法 | init(args:String[]) |
| 前置条件 | 用户已注册 |
| 后置条件 | 显示工作人员工作相应界面 |

*需要的服务（需接口）*  

| 服务名 | 服务 |
| --- | --- |
| logBlService.VerifyService.Login | 登录界面的业务逻辑接口 |
| logBlService.VerifyService.Redirect | 页面跳转的业务逻辑接口 |
| logBlService.InitialService.Init | 登录/创建用户界面初始化的业务逻辑接口 |

logUi.registerUi模块的接口规范  

*提供的服务（供接口）*  

| **logUi.registerUi** |  |
| :--- | :--- |
| 语法 | init(args:String[]) |
| 前置条件 | 无 |
| 后置条件 | 跳转至登录界面 |

*需要的服务（需接口）*  

| 服务名 | 服务 |
| --- | --- |
| logBlService.InitialService.Init | 登录/创建用户界面初始化的业务逻辑接口 |
| logBlService.RegisterService.Create | 创建用户界面的业务逻辑接口 |


salaesmanMainUi模块的接口规范  

*提供的服务（供接口）*  

| **salaesmanMainUi** |  |
| :--- | :--- |
| 语法 | init(args:String[]) |
| 前置条件 | 销售人员已成功登录 |
| 后置条件 | 显示客户管理或制定单据界面 |

*需要的服务（需接口）*  

| 服务名 | 服务 |
| --- | --- |
| salesBlService.initialSalesBlService | 制定单据界面初始化的业务逻辑接口 |
| viewBillUi.initViewBillUi | 显示进货销售人员查看单据的单据类型选择界面 |
| salesUi.initSalesUi | 显示进货销售人员制定单据的单据类型选择界面 |
| customerUi.initCustomerUi | 显示进货销售人员进行客户管理任务的操作选择界面 |


salesUi.initSalesUi模块的接口规范  

| **initSalesUi** |  |
| :--- | :--- |
| 语法 | init(args:String[]) |
| 前置条件 | 操作人员在salaesmanMainUi中选择了制定表单 |
| 后置条件 | 进入具体的单据类型选择中 |

*需要的服务（需接口）*  

| 服务名 | 服务 |
| --- | --- |
| salesUi.newPurchaseUi | 显示进货销售人员新建供应商进货单的界面 |
| salesUi.newPurReturnUi | 显示进货销售人员新建供应商进货退货单的界面 |
| salesUi.newSalesUi | 显示进货销售人员新建销售商出货单的界面 |
| salesUi.newSalReturnUi | 显示进货销售人员新建销售商出货退货单的界面 |
| salesUi.commoditySelectUi | 显示已有商品的名称列表的界面 |
| InitialSalesBlService | 选择制定具体单据类型的业务逻辑接口 |

salesUi.newPurchaseUi模块的接口规范  

| **salesUi.newPurchaseUi** |  |
| :--- | :--- |
| 语法 | show(args:String[]) |
| 前置条件 | 操作人员在initSalesUi中选择了制定进货单 |
| 后置条件 | 一张进货单生成待审批 |

*需要的服务（需接口）*  

| 服务名 | 服务 |
| --- | --- |
| salesBlService.SalesService.NewPurchase | 制定进货单界面的业务逻辑接口 |

salesUi.newPurReturnUi模块的接口规范  

| **salesUi.newPurReturnUi** |  |
| :--- | :--- |
| 语法 | show(args:String[]) |
| 前置条件 | 操作人员在initSalesUi中选择了制定进货退货单 |
| 后置条件 | 一张进货退货单生成待审批 |

*需要的服务（需接口）*  

| 服务名 | 服务 |
| --- | --- |
| salesBlService.SalesService.NewPurReturn | 制定进货退货单界面的业务逻辑接口 |

salesUi.newSalesUi模块的接口规范  

| **salesUi.newSalesUi** |  |
| :--- | :--- |
| 语法 | show(args:String[]) |
| 前置条件 | 操作人员在initSalesUi中选择了制定出货单 |
| 后置条件 | 一张出货单生成待审批 |

*需要的服务（需接口）*  

| 服务名 | 服务 |
| --- | --- |
| salesBlService.SalesService.NewSales | 制定出货单界面的业务逻辑接口 |

salesUi.newSalReturnUi模块的接口规范  

| **salesUi.newSalReturnUi** |  |
| :--- | :--- |
| 语法 | show(args:String[]) |
| 前置条件 | 操作人员在initSalesUi中选择了制定出货退货单 |
| 后置条件 | 一张出货退货单生成待审批 |

*需要的服务（需接口）*  

| 服务名 | 服务 |
| --- | --- |
| salesBlService.SalesService.NewSalReturn | 制定出货退货单界面的业务逻辑接口 |

salesUi.commoditySelectUi模块的接口规范  

| **salesUi.commoditySelectUi** |  |
| :--- | :--- |
| 语法 | show(args:String[]) |
| 前置条件 | 进货销售人员制定任意单据 |
| 后置条件 | 商品列表中商品名称得到填充 |

*需要的服务（需接口）*  

| 服务名 | 服务 |
| --- | --- |
| salesBlService.SalesService.CommoditySelect | 制定单据时商品选择界面的业务逻辑接口 |

customerUi.initCustomerUi模块的接口规范  

| **customerUi.initCustomerUi** |  |
| :--- | :--- |
| 语法 | void init(String number, string name) |
| 前置条件 | 操作人员在salaesmanMainUi中选择了客户管理 |
| 后置条件 | 进入具体的客户管理任务选择中 |

*需要的服务（需接口）*  

| 服务名 | 服务 |
| --- | --- |
| customerUi.addCustomerUi | 显示进货销售人员增加客户的界面 |
| customerUi.delCustomerUi | 显示进货销售人员删除客户的界面 |
| customerUi.modCustomerUi | 显示进货销售人员修改客户信息的界面 |
| customerUi.queryCustomerUi | 显示进货销售人员查询客户信息的界面 |
| customerUi.verifyUi | 显示修改客户应收额度时的身份验证界面 |
| customerBlService.InitialService.Init | 客户管理界面初始化的业务逻辑接口 |

customerUi.addCustomerUi模块的接口规范  

| **customerUi.addCustomerUi** |  |
| :--- | :--- |
| 语法 | show(args:String[]) |
| 前置条件 | 操作人员在initCustomerUi中选择了增加客户 |
| 后置条件 | 一个客户被添加进数据库中 |

*需要的服务（需接口）*  

| 服务名 | 服务 |
| --- | --- |
| customerBlService.CustomerService.AddCustomer | 新增客户界面的业务逻辑接口 |

customerUi.delCustomerUi模块的接口规范  

| **customerUi.delCustomerUi** |  |
| :--- | :--- |
| 语法 | show(args:String[]) |
| 前置条件 | 操作人员在initCustomerUi中选择了删除客户 |
| 后置条件 | 一个客户的所有数据从数据库中被删除 |

*需要的服务（需接口）*  

| 服务名 | 服务 |
| --- | --- |
| customerBlService.CustomerService.DelCustomer | 删除客户界面的业务逻辑接口 |

customerUi.modCustomerUi模块的接口规范  

| **customerUi.modCustomerUi** |  |
| :--- | :--- |
| 语法 | show(args:String[]) |
| 前置条件 | 操作人员在initCustomerUi中选择了修改客户信息 |
| 后置条件 | 一个客户的数据发生了变更 |

*需要的服务（需接口）*  

| 服务名 | 服务 |
| --- | --- |
| customerBlService.CustomerService.ModCustomer | 修改客户信息界面的业务逻辑接口 |

customerUi.queryCustomerUi模块的接口规范  

| **customerUi.queryCustomerUi** |  |
| :--- | :--- |
| 语法 | show(args:String[]) |
| 前置条件 | 操作人员在initCustomerUi中选择了查询客户信息 |
| 后置条件 | 显示客户所有信息 |

*需要的服务（需接口）*  

| 服务名 | 服务 |
| --- | --- |
| customerBlService.CustomerService.QueryCustomer | 查询客户信息界面的业务逻辑接口 |

customerUi.verifyUi模块的接口规范  

| **customerUi.verifyUi** |  |
| :--- | :--- |
| 语法 | public boolean show(args:String[]) |
| 前置条件 | 操作人员在modCustomerUi中选择了修改客户应收额度 |
| 后置条件 | 客户应收额度被修改 |

*需要的服务（需接口）*  

| 服务名 | 服务 |
| --- | --- |
| customerBlService.CustomerService.ModCustomer | 修改客户信息界面的业务逻辑接口 |
| customerBlService.CustomerService.Verify | 修改客户应收额度信息时身份验证界面的业务逻辑接口 |

FinancialStaffMainUi模块接口规范  

提供的服务（供接口）  

|**FinancialStaffMainUi**	||
|:----|:----|
|语法	|public void mainUi( )|
|	前置条件|	财务人员已登陆|
|	后置条件|	显示财务人员主界面|

需要的服务（需接口）  

|服务名||
|:-----| :--- |
|FinancialStaffBillStateUi.financialStaffBillStateUi( )|
|SalesDetailsListUi.salesDetailsListUi( )|
|BusinessProcessListUi.businessProcessListUi( )|
|BusinessConditionListUi.businessConditionListUi( )|
|ViewBankAccountsUi.viewBankAccountsUi( )|
|NewReceiptBillUi.newReceiptBillUi( )|
|NewPaymentBillUi.newPaymentBillUi( )|
|NewCashExpenseBillUi.newCashExpenseBillUi()|
|ViewInOutListUi.viewInOutListUi( )|

ViewRceiptBillUi模块接口规范  

提供的服务（供接口）  

|**ViewReceiptBillUi**|	|
|:----|:----|
|语法	|public void viewReceiptBillUi(String billId)
|前置条件|	已进入查看经营历程表的界面
|后置条件|	显示某张收款单的具体信息

需要的服务（需接口）  

|服务名|
|:----|
|viewBillBlService.ViewReceiptBillBlService|	
|billBlService.getBillService.getBill(String billName,String billId)|

ViewPaymentBillUi模块接口规范  

提供的服务（供接口）  

|**ViewPaymentBillUi**||	
|:----|:----|
|语法|	public void viewPaymentBillUi(String billId)
|前置条件|已进入查看经营历程表的界面
|后置条件|	显示某张付款单的具体信息

需要的服务（需接口）

|服务名|
|:----|
|viewBillBlService.ViewPaymentBillBlService|	
|billBlService.getBillService.getBill(String billName,String billId)|

ViewCashExpenseBillUi模块接口规范  

提供的服务（供接口）  

|**ViewCashExpenseBillUi**|
|:----|:----|
|语法	|public void viewCashExpenseBillUi(String billId)
|前置条件|	已经进入查看经营历程表的界面
|后置条件|显示某张现金费用单的具体信息

需要的服务（需接口）

|服务名|
|:----|
|viewBillBlService.ViewCashExpenseBillBlService|	
|billBlService.getBillService.getBill(String billName,String billId)|

viewBillBlUi.viewPurWaitBillUi模块的接口规范  

| **viewBillBlUi.viewPurWaitBillUi** |  |
| :--- | :--- |
| 语法 | view(args:String[]) |
| 前置条件 | 用户已登录 |
| 后置条件 | 界面显示待审批进货单信息 |

*需要的服务（需接口）*  

| 服务名 | 服务 |
| --- | --- |
| viewSalsemanBlService | 显示销售人员表单信息的业务逻辑接口 |

viewBillBlUi.viewPurRetWaitBillUi模块的接口规范  

| **viewBillBlUi.viewPurRetWaitBillUi** |  |
| :--- | :--- |
| 语法 | view(args:String[]) |
| 前置条件 | 用户已登录 |
| 后置条件 | 界面显示待审批进货退货单信息 |

*需要的服务（需接口）*  

| 服务名 | 服务 |
| --- | --- |
| viewSalsemanBlService | 显示销售人员表单信息的业务逻辑接口 |

viewBillBlUi.viewSalWaitBillUi模块的接口规范  

| **viewBillBlUi.viewSalWaitBillUi** |  |
| :--- | :--- |
| 语法 | view(args:String[]) |
| 前置条件 | 用户已登录 |
| 后置条件 | 界面显示待审批出货单信息 |

*需要的服务（需接口）*  

| 服务名 | 服务 |
| --- | --- |
| viewSalsemanBlService | 显示销售人员表单信息的业务逻辑接口 |

viewBillBlUi.viewSalRetWaitBillUi模块的接口规范  

| **viewSalRetWaitBillUi** |  |
| :--- | :--- |
| 语法 | view(args:String[]) |
| 前置条件 | 用户已登录 |
| 后置条件 | 界面显示待审批出货退货单信息 |

*需要的服务（需接口）*  

| 服务名 | 服务 |
| --- | --- |
| viewSalsemanBlService | 显示销售人员表单信息的业务逻辑接口 |

ViewWareKeeperBillUi模块接口规范  

提供的服务（供接口）  

|**viewWareKeeperBillUi.viewInventoryWarningBill**||	
|:----|:----|
|语法|public void viewInventoryWarningBill(String billID);|
|前置条件|在单据菜单栏里选择了库存报警单|
|后置条件|显示该单据|
|viewWareKeeperBillUi.viewInventoryOverBill||
|语法|public void viewInventoryOverBill(String billID);|
|前置条件|在单据菜单栏里选择了库存报溢单|
|后置条件|显示该单据|
|viewWareKeeperBillUi.viewInventoryLossBill||
|语法|public void viewInventoryLossBill(String billID);|
|前置条件|在单据菜单栏里选择了库存报损单|
|后置条件|显示该单据|

*需要的服务（需接口）*  

| 服务名 | 服务 |
| --- | --- |
| viewWareKeeperBillBlService | 显示销售人员表单信息的业务逻辑接口 |


WareKeeperBillStateUi模块接口规范  

提供的服务（供接口）  

|**WareKeeperBillStateUi**||	
|:----|:----|
|语法|public void wareKeeperBillStateUi( )
|前置条件|	已经进入仓库管理员主界面
|后置条件	|显示仓库管理员单据状态界面

需要的服务接口（需接口）

|服务名|
|:------|
|billStateBlService.WareKeeperBillStateBlService|

SalesmanBillStateUi模块接口规范  

提供的服务（供接口）  

|**SalesmanBillStateUi**|	|
|:----|:----|
|语法|	public void salesmanBillStateUi( )
|前置条件|已经进入进货销售人员主界面
|后置条件|显示进货销售人员单据状态界面

需要的服务接口（需接口）

|服务名|
|:------|
|billStateBlService.SalesmanBillStateBlService|

FinancialStaffBillStateUi模块接口  

提供的服务（供接口）  

|**FinancialStaffBillStateUi**||
|:----|:----|
|语法|public void financialStaffBillStateUi( )
|前置条件|	已经进入财务人员主界面
|后置条件|	显示财务人员单据状态

需要的服务接口（需接口）

|服务名|
|:------|
|billStateBlService.FinancialStaffBillStateBlService|

SalesDetailsListUi模块接口规范  

提供的服务（供接口）  

|**SalesDetailsListUi**	||
|:----|:----|
|语法	|public void salesDetailsListUi( )
|前置条件	|已经进入总经理或财务人员主界面
|后置条件|	显示销售明细表

需要的服务接口（需接口）

|服务名|
|:-----|
|listBlService.SalesDetailsListBlService|

BusinessProcessListUi模块接口规范  

提供的服务（供接口）  

|**BusinessProcessListUi**	||
|:----|:----|
|语法	|public void businessProcessListUi( )
|前置条件	|已经进入总经理或财务人员主界面
|后置条件	|显示经营历程表

需要的服务接口（需接口）

|服务名|
|:-----|
|listBlService.BusinessProcessListBlService|

BusinessConditionListUi模块接口规范  

提供的服务（供接口）  

|**BusinessConditionListUi**|	|
|:----|:----|
|语法|	public void businessConditionListUi( )
|前置条件|	已经进入总经理或财务人员主界面
|后置条件|显示经营情况表

需要的服务接口（需接口）

|服务名|
|:-----|
|listBlService.BusinessConditionListBlService|

NewModifyBillUi模块接口规范  

提供的服务（供接口）  

|**NewModifyBillUi**||
|:----|:----|
|语法|	public void newModifyBillUi( )
|前置条件	|已经进入查看经营历程表的界面
|后置条件	|显示某张红冲单据

需要的服务接口（需接口）

|服务名|
|:-----|
|ListBlService.NewModifyBillBlService|

NewModifyCopyBillUi模块接口规范  

提供的服务（供接口）  

|**NewModifyCopyBillUi**|
|:----|:----|
|语法|public void newModifyCopyBillUi( )
|前置条件|已经进入查看经营历程表的界面
|后置条件|显示某张红冲并复制单据

需要的服务接口（需接口）

|服务名|
|:-----|
|ListBlService.NewModifyCopyBillBlService|

ViewBankAccountsUi模块接口规范  

提供的服务（供接口）  

|**ViewBankAccountsUi**	||
|:----|:----|
|语法|	public void viewBankAccountsUi( )
|前置条件|	已经进入财务人员主界面
|后置条件	|显示银行账户列表

需要的服务接口（需接口）

|服务名|
|:-----|
|financeBlService.ViewBankAccountsBlService|

NewBankAccountsUi模块接口规范  

提供的服务（供接口）  

|**NewBankAccountsUi**||
|:----|:----|
|语法	|public void newBankAccountsUi( )
|前置条件|	已经进入银行账户列表界面
|后置条件|显示新建银行账户列表

需要的服务接口（需接口）

|服务名|
|:-----|
|financeBlService.NewBankAccountBlService

NewReceiptBillUi模块接口规范  

提供的服务（供接口）  

|**NewReceiptBillUi**|	|
|:----|:----|
|语法|public void newReceiptBillUi( )
|前置条件|	已经进入财务人员主界面
|后置条件|	显示新建收款单的界面

需要的服务接口（需接口）

|服务名|
|:-----|
|financeBlService.NewReceiptBillBlService|

NewPaymentBillUi模块接口规范  

提供的服务（供接口）  

|**NewPaymentBillUi**|	|
|:----|:----|
|语法|public void newPaymentBillUi( )
|前置条件|	已经进入财务人员主界面
|后置条件|	显示新建付款单的界面

需要的服务接口（需接口）

|服务名|
|:-----|
|financeBlService.NewPaymentBillBlService|

NewCashExpenseBillUi接口规范  

提供的服务（供接口）  

|**NewCashExpenseBillUi**||
|:----|:----|
|语法	|public void newCashExpenseBillUi( )
|前置条件|	已经进入财务人员主界面
|后置条件|	显示新建现金费用单界面

需要的服务接口（需接口）

|服务名|
|:-----|
|financeBlService.NewCashExpenseBillBlService|

ViewInOutListUi接口规范  

提供的服务（供接口）  

|**ViewInOutListUi**||
|:----|:----|
|语法|public void viewInOutListUi( )
|前置条件|	已经进入财务人员主界面
|后置条件|	显示账单列表

需要的服务接口（需接口）

|服务名|
|:-----|
|financeBlService.ViewInOutListBlService|

ViewInitialInformationUi模块接口规范  

提供的服务（供接口）  

|**ViewInitialInformationUi**||
|:----|:----|
|语法|	public void viewInitialInformationUi(String inOutYear)
|前置条件|	已经进入账单列表界面
|后置条件|	显示某一套账的期初信息

需要的服务接口（需接口）

|服务名|
|:-----|
|financeBlService.ViewInitialInformationBlService|

ViewInOutDetailsUi模块接口规范  

提供的服务（供接口）  

|**ViewInOutDetailsUi**	||
|:----|:----|
|语法|public void viewInOutDetailsUi(String inOutYear)
|前置条件|已经进入账单列表界面
|后置条件|	显示某套账的明细
需要的服务接口（需接口）
|服务名|
|:-----|
|financeBlService.ViewInOutDetailsBlService|

NewInOutUi模块接口规范  

提供的服务（供接口）  

|**NewInOutUi**||
|:----|:----|
|语法|	public void newInOutUi()
|前置条件|	已经进入账单列表界面
|后置条件|	显示新建账单界面

需要的服务接口（需接口）

|服务名|
|:-----|
|financeBlService.NewInOutBlService	|

managerMainUi模块接口规范  

*提供的服务（供接口）*  

|**managerMainUi.initListUi**| |
| :--- | :--- |
|语法| public void initListUi()|
|前置条件|总经理进行查看表单操作  |
|后置条件|进入表单操作界面  |
|**managerMainUi.viewBillUi** | |
|语法| public void viewBillUi()|
|前置条件|总经理进行查看单据操作  |
|后置条件|进入单据查看界面  |
|**managerMainUi.initPromotionUi** | |
|语法| public void initPromotionUi()|
|前置条件|总经理进行制定促销策略操作  |
|后置条件|进入制定促销策略操作界面  |

*需要的服务（需接口）*  

|服务名 |服务 |
| :--- | :--- |
|logUi.initManagerMainUi|进入总经理“功能选择”界面|

adminMainUi模块接口规范

*提供的服务（供接口）*

|**adminMainUi.initAdminUi** | |
| :--- | :--- |
|语法| public void initAdminUi()|
|前置条件|管理员进行管理用户操作  |
|后置条件|进入管理用户操作界面  |

*需要的服务（需接口）*  

|服务名 |服务 |
| :--- | :--- |
|logUi.initAdminMainUi|进入总经理功能选择界面|

adminUi模块接口规范  

*提供的服务（供接口）*  

|**adminUi.initAdminMainUi** | |
| :--- | :--- |
|语法| public void initAdminMainUi()|
|前置条件|管理员完成操作  |
|后置条件|进入管理用功能选择界面  |

*需要的服务（需接口）*  

|服务名 |服务 |
| :--- | :--- |
|adminService.getUser(String name,String userId)|得到某一个用户信息|
|adminService.addUser(UserVo user)|增加某一个新用户|
|adminService.deleteUser(String name,String Id)|删除某一个用户|
|adminService.updateUser(UserVo user)|更新某一个员工信息|

approveBillUi模块接口规范  

*提供的服务（供接口）*  

|**approveBillUi.initManagerMainUi**| |
| :--- | :--- |
|语法| public void initManagerMainUi()|
|前置条件|总经理完成审批单据操作   |
|后置条件|进入总经理功能选择界面    |
|**approveBillUi.initBillUi**| |
|语法| public void initBillUi(String billName,String billId)|
|前置条件|总经理查看某一个具体的单据   |
|后置条件|打开某一个单据的显示界面    |

*需要的服务（需接口）*  

|服务名 |服务 |
| :--- | :--- |
| approveService.getBillsList  |得到未审批的单据列表|
| approveService.passBills  |通过选中的单据|
| approveService.denyBills  |拒绝通过选中的单据|

promotionUi模块接口规范  

*提供的服务（供接口）*  

| **promotionUi.initManagerMainUi** | |
| :--- | :--- |
|语法| public void initManagerMainUi()|
|前置条件|总经理完成审批单据操作   |
|后置条件|进入总经理功能选择界面    |
| **promotionUi.initCommodityUi** | |
|语法| public void initCommodityUi(CommodityVo commodity)|
|前置条件|总经理完成审批单据操作   |
|后置条件|进入总经理功能选择界面   |

*需要的服务（需接口）*  

|服务名 |服务 |
| :--- | :--- |
| CommodityBlService.getCommodity() | 得到某个商品信息    |
| promotionBlService.getUserStrategyList() | 得到用户促销策略列表    |
| promotionBlService.getTotalStrategyList() | 得到总价格促销策略列表          |
| promotionBlService.getComoboStrategyList() |  得到组合促销策略列表         |
|promotionBlService.deleteStrategy(String strategyType ,String strategyId)|删除某一促销策略|
|promotionBlService.addUserStrategy(UserStrategyVo strategy)|新增用户促销策略促销策略|
|promotionBlService.addTotalStrategy(TotalStrategyVo strategy)|新增总价促销策略|
|promotionBlService.addComobStrategy(ComobStrategyVo strategy)|新增组合促销策略|


####**5.2.3 用户界面模块设计原理**  
用户界面模块利用javafx来实现。  



-------------    



###5.3、业务逻辑层的分解  
业务逻辑包括多个针对界面的业务逻辑处理对象。例如，查看收付款单界面需要由viewReceiptBlService接口提供业务逻辑服务，新建银行账户界需要由newBankAccountsBlService接口提供业务逻辑服务。业务逻辑层的设计如图12
![图12](http://101.37.19.32:10080/namenotdiscussed/LightingSalesSystem/raw/master/体系结构设计2作业图/业务逻辑层设计.png)
所示。  

####**5.3.1、模块的职责**  

|模块|职责|
| :--- | :-- |
|commodityBl|仓库管理逻辑包,包含仓库管理所有功能的类|
|commodityBl.GoodsClassificationBl|负责实现库存分类管理界面所需要的服务|
|commodityBl.AddGoodsBl|负责实现增加商品界面所需要的服务|
|commodityBl.DeleteGoodsBl|负责实现删除商品界面所需要的服务|
|commodityBl.GoodsInforBl|负责实现商品信息管理界面所需要的服务|
|commodityBl.StockCheckBl|负责实现库存审查界面所需要的服务|
|commodityBl.InventoryCheckBl|负责实现库存盘点界面所需要的服务|
|commodityBl.ActualInventoryCheckBl|负责实现实际库存确认界面所需要的服务|
|commodityBl.SavaBillBl|负责保存库存管理员制定的单据|
| logBl | 负责实现用户创建和登录界面所需要的服务 |
| viewBillBl | 负责实现查看单据内容所需要的服务 |
| salesBl | 负责实现进货销售人员制定各种表单所需要的服务 |
| customerBl | 负责实现进货销售人员进行客户管理所需要的服务 |
|ViewPaymentBillBl|	负责查看付款单界面所需要的服务。
|ViewReceiptBillBl	|负责查看收款单界面所需要的服务。
|ViewCashExpenseBillBl|	负责查看现金费用单界面所需要的服务。
|ViewWareKeeperBillBl|查看仓库管理制定的单据，包括库存报警单、报溢单、报损单|
|ViewSalesManBillBl|查看销售人员制定的单据|
|WareKeeperBillStateBl	|负责仓库管理员查看单据状态所需要的服务。单据状态包括：审核通过待处理、未通过审核的单据的信息。
|SalesmanBillStateBl	|负责销售进货员查看单据状态所需要的服务。单据状态包括：审核通过待处理、未通过审核的单据的信息。
|FinancialStaffBillStateBl	|负责财务人员查看单据状态所需要的服务。单据状态包括：审核通过待处理、未通过审核的单据的信息。
|SalesDetailsListBl|	读取并解析所有销售出货单据的具体信息
|BusinessProcessListBl	|读取并解析所有单据的具体信息
|BusinessConditionListBl	|读取并解析收付款单的具体信息，并计算某一时期内的利润
|NewModifyBillBl|	将红冲单据的信息保存并提交审核
|NewModifyCopyBillBl|	将红冲并复制单据的信息保存并提交审核
|ViewBankAccountsBl|	读取并解析银行账户信息
|NewBankAccountBl	|负责新建银行账户界面所需要的服务
|NewReceiptBillBl|	负责新建收款单界面所需要的服务
|NewPaymentBillBl|	负责新建付款单界面所需要的服务
|NewCashExpenseBillBl|	负责新建现金费用单界面所需要的服务
|ViewInOutListBl|	负责查看账单列表界面所需要的服务
|ViewInitialInformationBl|	负责查看期初信息界面所需要的服务
|ViewInOutDetailsBl|	负责查看一套账明细的界面所需要的服务
|NewInOutBl	|负责新建一套账的界面所需要的服务
|NewBankAccountBlHelper|负责新建银行账户界面所需要的服务的具体细节
|ViewBankAccountsBlHelper|读取并解析银行账户信息的具体细节
|ViewInitialInformationBlHelper|负责查看期初信息界面所需要的服务的具体细节
|ViewInOutDetailsBlHelper|负责查看一套账明细的界面所需要的服务的具体细节
|ViewInOutListBlHelper|负责查看账单列表界面所需要的服务的具体细节
|approveBillBl |负责实现审批单据的所需要的服务|
|  billBl  |负责实现单据查询、带筛选查询、单据通过后数据更新服务|
| promotionBl|负责实现促销策略制定删除的服务|
| adminBl |提供用户管理的服务|


####**5.3.2、接口规范**  
#####commodityBl.GoodsClassificationBl模块的接口规范  

*提供的服务（供接口）*  

|GoodsClassificationBl.getClassificationTree|服务|
| :--- | :--- |
|语法|public ClassificationTreeVO getClassificationTree() throws RemoteException; |
|前置条件|启动一个库存分类管理回合或者商品信息管理回合|
|后置条件|返回商品类别树|
|**GoodsClassifcationBl.ifClassificationExist**||
|语法|public boolean ifClassificationExist(String classificationTag) throws RemoteException; |
|前置条件|classificationTag符合商品类别标识格式|
|后置条件|返回该类别是否存在的boolean值|
|**GoodsClassifcationBl.addNewClassification**||
|语法|public boolean addNewClassification（ClassificationVO vo）throws RemoteException;|
|前置条件|启动一个增加新类别回合|
|后置条件|自动生成一个新编号，存储新类别信息，更新类别数据，返回增加成功的boolean|
|**GoodsClassifcationBl.classificationInfor**||
|语法|public ClassificationVO classificationInfor(String classificationNum) throws RemoteException;|
|前置条件|启动一个类别信息查看回合|
|后置条件|返回类别信息|
|**GoodsClassifcationBl.addClassification**||
|语法|public boolean addClassification(ClassificationVO vo) throws RemoteException;|
|前置条件|启动一个增界子类别回合|
|后置条件|自动生成一个新编号，存储新类别信息，更新类别数据，返回增加成功的boolean|
|**GoodsClassifcationBl.deleteClassification**||
|语法|public boolean deleteClassification(ClassificationVO vo) throws RemoteException;|
|前置条件|启动一个删除类别回合|
|后置条件|删除该类别，更新类别数据，返回删除成功的boolean|
|**GoodsClassifcationBl.modifyClassificationOfGoods**||
|语法|public boolean modifyClassificationOfGoods(GoodsVO vo) throws RemoteException;|
|前置条件|启动一个修改所属类别回合|
|后置条件|修改该类别所属类别，更新类别数据，返回修改成功的bool|
|**GoodsClassifcationBl.modifyClassificationInfor**||
|语法|public boolean modifyClassificationInfor(ClassificationVO vo) throws RemoteException;|
|前置条件|开启一个修改类别信息回合|
|后置条件|修改该类别信息，更新类别数据，返回修改成功的boolean|

*需要的服务（需接口）*

|服务名|服务|
| :--- | :--- |
|commodityDataService.GoodsClassificationDataService.finds()|获得所有类别|
|commodityDataService.GoodsClassificationDataService.find(String calssificationTag)|获得某类别信息|
|commodityDataService.GoodsClassificationDataService.insert(SlassificationPO po)|插入一个类别|
|commodityDataService.GoodsClassificationDataService.delete(ClassificationPO po)|删除一个类别|
|commodityDataService.GoodsClassificationDataService.update(ClassificationPO po)|更新一个类别|

commodityBl.AddGoodsBl模块的接口规范  

*提供的服务（供接口）*  


|AddGoodsBl.addNewGoods|
| :--- | :--- |
|语法|public boolean addNewGoods(GoodsVO goodsVO,StockInOutVO stockVO) throws RemoteException; |
|前置条件|启动一个增加新商品的回合|
|后置条件|自动生成一个新的商品编号，存储新商品信息与入库信息，更新商品数据，更新类别数据，返回增加成功的boolean|
|**AddGoodsBl.add**||
|语法|public boolean add(StockInOutVO vo) throws RemoteException;|
|前置条件|启动一个增加商品的回合|
|后置条件|存储商品的入库信息，更新出入库情况数据，更新商品数据，返回商品增加成功的boolean|

*需要的服务（需接口）*

|服务名|服务|
| :--- | :--- |
|commodityDataService.GoodsDataService.insert（GoodsPO po）|插入新商品|
|commodityDataService.GoodsClassificationDataService.update(ClassificationPO po)|更新一个类别|
|commodityDataService.GoodsDataService.update（GoodsPO po）|更新商品信息（库存）|
|commodityDataService.StockInOutRecordService.insert(StockInOutPO po)|插入一条出入库情况信息|

commodityBl.DeleteGoods模块的接口规范  

*提供的服务（供接口）*  

|DeleteGoodsBl.delete||
| :--- | :--- |
|语法|public boolean delete(StockInOutVO VO) throws RemoteException; |
|前置条件|开启一个减少商品回合|
|后置条件|存储商品的出库信息，更新出入库情况数据，更新商品数据，返回商品减少成功的boolean|
|**DeleteGoodsBl.obsoleteGoods**||
|语法|public boolean obsoleteGoods(String goodsNum) throws RemoteException;|
|前置条件|开启一个删除商品的回合|
|后置条件|彻底删除一个商品，更新商品数据，更新类别数据，返回删除成功的boolean|
|**DeleteGoodsBl.compareToWarning**||
|语法|public int compareTowarning(String goodsTag，int currentAmout) throws RemoteException;|
|前置条件|商品减少|
|后置条件|返回该商品警戒值和该商品当前系统库存的差值|

*需要的服务（需接口）*

|服务名|服务|
| :--- | :--- |
|commodityDataService.GoodsDataService.delete（GoodsPO po）|删除一个商品|
|commodityDataService.GoodsClassificationDataService.update(ClassificationPO po)|更新一个类别|
|commodityDataService.GoodsDataService.update（GoodsPO po）|更新商品信息（库存）|
|commodityDataService.StockInOutRecordService.insert(StockInOutPo po)|插入一条出入库情况信息|

commodityBl.GoodsInforBl模块的接口规范  

*提供的服务（供接口）*  

|GoodsInforBl.ifGoodsExist||
| :--- | :--- |
|语法|public boolean ifGoodsExist(String goodsID) throws RemoteException; |
|前置条件|开启一个商品查找回合|
|后置条件|返回该编号的商品是否存在的boolean|
|GoodsInforBl.ifGoodsExist||
| :--- | :--- |
|语法|public boolean ifGoodsExist(String goodsName,String goodsType) throws RemoteException; |
|前置条件|开启一个商品查找回合|
|后置条件|返回该名称和型号的商品是否存在的boolean|
|**GoodsInforBl.goodsINfor**||
|语法|public GoodsVO goodsINfor(String goodsTag) throws RemoteException;|
|前置条件|开启一个商品信息查询回合|
|后置条件|返回一个商品对象|
|**GoodsInforBl.modifyGoodsInfor**||
|语法|public boolean modifyGoodsInfor(GoodsVO vo) throws RemoteException;|
|前置条件|开启一个商品信息修改回合|
|后置条件|修改一个商品的信息，返回修改成功的boolean|
|**GoodsInforBl.getGoodsList**||
|语法|public GoodsListVO getGoodsList() throws RemoteException;|
|前置条件|无|
|后置条件|返回商品清单vo对象|

*需要的服务（需接口）*  

|服务名|服务|
| :--- | :--- |
|commodityDataService.GoodsDataService.finds|获得所有商品|
|commodityDataService.GoodsDataService.finds(String goodsTag)|根据输入查找多个符合的商品|
|commodityDataService.GoodsDataService.find(String goodsTag)|获得某个商品的信息|
|commodityDataService.GoodsDataService.update(GoodsPO po)|更新某个商品|

commodityBl.StockCheckBl模块的接口规范  

*提供的服务（供接口）*

|StockCheckBl.stockCheckSheet||
| :--- | :--- |
|语法|public StockCheckSheetVO stockCheckSheet(String beginTime,String endTime) throws RemoteException; |
|前置条件|开启一个库存审查回合|
|后置条件|返回库存审查表对象|

*需要的服务（需接口）*  

|服务名|服务|
| :--- | :--- |
|commodityDataService.StockInOutRecordService.finds(String beginTime,String endTime)|根据时间段查找给时间段内的出入库情况信息|


commodityBl.InventoryCheckBl模块的接口规范  

*提供的服务（供接口）*  

|InventoryCheckBl.inventoryCheckSheet||
| :--- | :--- |
|语法|public InventoryCheckSheetVO inventoryCheckSheet(String date) throws RemoteException; |
|前置条件|开启一个库存盘点回合|
|后置条件|返回一个库存快照表对象|

*需要的服务（需接口）*
|服务名|服务|
| :--- | :--- |
|commodityDataService.StockInOutRecordService.finds(String date)|根据日期查找该日期内的出入库情况信息|

commodityBl.ActualInventoryCheckBl模块的接口规范  
*提供的服务（供接口）*

|ActualInventoryCheckBl.actualInventoryCheck||
| :--- | :--- |
|语法|public int actualInventoryCheck(String goodsTag,int actualAmount) throws RemoteException; |
|前置条件|开启一个实际库存确认回合|
|后置条件|返回该实际库存值和该商品当前系统库存的差值|

*需要的服务（需接口）*

|服务名|服务|
| :--- | :--- |
|GoodsDataService.find(String tag)|获得某个商品的信息|

commodityBl.SaveBillBl模块的接口规范  

*提供的服务（供接口）*  

|SaveBill.saveInventoryWarningBill||
| :--- | :--- |
|语法|public boolean saveInventoryWarningBill(InventoryWarningBillVO  bill) throws RemoteException;|
|前置条件|无|
|后置条件|返回保存库存警戒单成功的boolean|
|**SaveBillBl.saveInventoryLossBill**||
|语法|public boolean saveInventoryLossBill(InventoryLossBillVO  bill) throws RemoteException;|
|前置条件|无|
|后置条件|返回保存库存报损单成功的boolean|
|**SaveBillBl.saveInventoryOverBill**||
|语法|public boolean saveInventoryOverBill(InventoryOverBillVO  bill) throws RemoteException;|
|前置条件|无|
|后置条件|返回保存库存报溢单成功的boolean|

*需要的服务（需接口）*  

|服务名|服务|
| :--- | :--- |
|billBlService.CreateBillBl.createInventoryWarningBill(InventoryWarningBillVo bill)|保存库存警戒单到单据数据中|
|billBlService.CreateBillBl.createInventoryLossBill(InventoryLossBillVo bill)|保存库存报损单到单据数据中|
|billBlService.CreateBillBl.createInventoryOverBill(InventoryOverBillVo bill)|保存库存报溢单到单据数据中|

***logBl模块的接口规范***  

*提供的服务（供接口）*  

| **Register.Create** |  |
| :--- | :--- |
| 语法 | public boolean Create(UserVO vo) |
| 前置条件 | 注册需要的用户信息输入符合规则 |
| 后置条件 | 数据库中新增一个客户，根据新建操作是否成功返回新建用户的结果 |
| **Verify.Login** |  |
| 语法 | public String Login(String number, String password) |
| 前置条件 | password输入符合规则 |
| 后置条件 | 查找是否存在相应用户，根据输入的password返回登录验证的结果（员工编号） |
| **Verify.Redirect** |  |
| 语法 | public void Redirect() |
| 前置条件 | 使用者已成功登录 |
| 后置条件 | 根据员工编号跳转至相应工作界面 |

*需要的服务（需接口）*

| 服务名 | 服务 |
| --- | --- |
| UserDataService.Insert(userVo vo) | 在数据库中插入UserPO对象 |
| UserDataService.Find(String number, String password) | 在数据库中查找UserPO对象 |

***salesBl模块的接口规范***  

*提供的服务（供接口）*  

| **Initial.Init** |  |
| :--- | :--- |
| 语法 | public void Init() |
| 前置条件 | 用户成功登录并被验证为进货销售人员，选择制单类型 |
| 后置条件 | 根据选择的类型跳转到制单具体任务处理 |
| **Sales.NewPurchase** |  |
| 语法 | public boolean NewPurchase(PurchaseBillVo vo) |
| 前置条件 | 启动一个进货销售人员制定单据回合 |
| 后置条件 | 在一个制定单据回合中，新建一张供应商进货单 |
| **Sales.NewPurReturn** |  |
| 语法 | public boolean NewPurReturn(PurchaseReturnBillVo vo) |
| 前置条件 | 启动一个进货销售人员制定单据回合 |
| 后置条件 | 在一个制定单据回合中，新建一张供应商进货退货单 |
| **Sales.NewSales** |  |
| 语法 | public boolean NewSales(SalesBillVo vo) |
| 前置条件 | 启动一个进货销售人员制定单据回合 |
| 后置条件 | 在一个制定单据回合中，新建一张销售商出货单 |
| **Sales.NewSalReturn** |  |
| 语法 | public boolean NewSalReturn(SalesReturnBillVo vo) |
| 前置条件 | 启动一个进货销售人员制定单据回合 |
| 后置条件 | 在一个制定单据回合中，新建一张销售商出货退货单 |
| **Sales.CommoditySelect** |  |
| 语法 | public arrayList< String > CommoditySelect() |
| 前置条件 | 启动一个进货销售人员制定单据回合 |
| 后置条件 | 销售人员新建单据时商品列表中商品名称被填充 |

*需要的服务（需接口）*

| 服务名 | 服务 |
| --- | --- |
| billBl.CreateBillBl.createPurchaseBill(PurchaseBillVo bill) | 创建一张进货单的业务逻辑接口 |
| billBl.CreateBillBl.createPurchaseReturnBill(PurchaseReturnBillVo bill) | 创建一张进货退货单的业务逻辑接口 |
| billBl.CreateBillBl.createSalesBill(SalesBillVo bill) | 创建一张出货单的业务逻辑接口 |
| billBl.CreateBillBl.createSalesReturnBill(SalesReturnBillVo bill) | 创建一张进货退货单的业务逻辑接口 |
| commodityBl.GoodsInfo.getGoodsList() | 得到商品列表的业务逻辑接口 |


***customerBl模块的接口规范***  

*提供的服务（供接口）*  

| **Initial.Init** |  |
| :--- | :--- |
| 语法 | public void Init() |
| 前置条件 | 用户成功登录并被验证为进货销售人员，选择客户管理具体任务 |
| 后置条件 | 根据选择的类型跳转到客户管理具体任务处理过程 |
| **Customer.AddCustomer** |  |
| 语法 | public boolean AddCustomer(CustomerVO vo) |
| 前置条件 | 启动一个客户管理任务回合 |
| 后置条件 | 数据库中新增一个客户和他的信息 |
| **Customer.DelCustomer** |  |
| 语法 | public boolean DelCustomer(String number, String name) |
| 前置条件 | 启动一个客户管理任务回合 |
| 后置条件 | 一个客户和他的所有信息被删除 |
| **Customer.ModCustomer** |  |
| 语法 | public boolean ModCustomer(CustomerVO vo) |
| 前置条件 | 启动一个客户管理任务回合 |
| 后置条件 | 一个客户的信息更新 |
| **Customer.QueryCustomer** |  |
| 语法 | public CustomerVO QueryCustomer(String name) |
| 前置条件 | 启动一个客户管理任务回合 |
| 后置条件 | 一个客户的信息被显示 |
| **Customer.Verify** |  |
| 语法 | public boolean CustomerVO(String number, String password) |
| 前置条件 | 操作人员处于修改客户信息任务中 |
| 后置条件 | 操作人员可以修改客户信息中的应收额度 |
| **Customer.Provide** |  |
| 语法 | public boolean Provide(String CustomerNum, double amount) |
| 前置条件 | 操作人员处于制定收付款单任务中 |
| 后置条件 | 操作人员可以修改客户信息中的应收应付信息 |

*需要的服务（需接口）*

| 服务名 | 服务 |
| --- | --- |
| customerDataService.insert(CustomerVo vo) | 插入单一持久化对象 |
| customerDataService.delete(String number, String name) | 删除单一持久化对象 |
| customerDataService.update(CustomerPo vo) | 更新单一持久化对象 |
| customerDataService.find(String name) | 根据ID进行查找持久化对象 |

viewBillBl模块接口规范  

提供的服务（供接口）  

|**ViewReceiptBillBl.getInfo**|	|
|:---|:---|
|语法|	public ReceiptBillVO| getInfo(String billId)
|前置条件|	财务人员点击某张收款单以查看具体信息
|后置条件|	读取并解析收款单的信息
|**ViewPaymentBillBl.getInfo**	||
|语法|	public PaymentBillVO getInfo(String billId)
|前置条件|财务人员点击某张付款单以查看具体信息
|后置条件|	读取并解析付款单的信息
|**ViewCashExpenseBl.getInfo**	||
|语法|	public String[ ] getInfo(String billId)
|前置条件|	财务人员点击某张现金费用单以查看信息
|后置条件|	读取并解析现金费用单的信息

需要的服务接口（需接口）

|服务名||
|:-----|:----|
|billBl.get	|在数据库中读出所需单据信息

ViewWareKeeperBillBl模块的接口规范  

*提供的服务*  

|ViewWareKeeperBillBl.getInventoryWarningBill||
| :--- | :--- |
|语法|public InventoryWarningBillVO getInventoryWarningBill(String billID);|
|前置条件|存在同ID仓库报警单|
|后置条件|返回同ID仓库报警单对象vo|
|ViewWareKeeperBillBl.getInventoryLossBill||
|语法|public InventoryLossBillVO getInventoryLossBill(String billID);|
|前置条件|存在同ID仓库报损单|
|后置条件|返回同ID仓库报损单对象vo|
|ViewWareKeeperBillBl.getInventoryOverBill||
|语法|public InventoryOverBillVO getInventoryOverBill(String billID);|
|前置条件|存在同ID仓库报溢单|
|后置条件|返回同ID仓库报溢单对象vo|

*需要的服务（需接口）*  

|服务名|服务|
| :--- | :--- |
|billBlService.GetBillBlService.getBill(String billType,String billID)|提供相同ID的库存警戒单|

viewSalsemanBillBl模块的接口规范  

*提供的服务（供接口）*  

| **ViewSalsemanBillBl.getPurchaseBill** |  |
| :--- | :--- |
| 语法 | public PurchaseBillVO getPurchaseBill(String billNum) |
| 前置条件 | 操作人员选择查看供应商进货单信息 |
| 后置条件 | 一张供应商进货单的所有信息被显示 |
| **ViewSalsemanBillBl.getPurchaseReturnBill** |  |
| 语法 | public PurchaseReturnBillVO getPurchaseReturnBill(String billNum) |
| 前置条件 | 操作人员选择查看供应商进货退货单信息 |
| 后置条件 | 一张供应商进货退货单的所有信息被显示 |
| **ViewSalsemanBillBl.getSalesBill** |  |
| 语法 | public SalesBillVO getSalesBill(String billNum) |
| 前置条件 | 操作人员选择查看销售商出货单信息 |
| 后置条件 | 一张销售商出货单的所有信息被显示 |
| **ViewSalsemanBillBl.getSalesReturnBill** |  |
| 语法 | public SalesReturnBillVO getSalesReturnBill(String billNum) |
| 前置条件 | 操作人员选择查看销售商出货退货单信息 |
| 后置条件 | 一张销售商出货退货单的所有信息被显示 |

*需要的服务（需接口）*  

| 服务名 | 服务 |
| --- | --- |
| GetBillBlService.getBill(String billName,String billId) | 根据ID和名称进行查找持久化对象 |


billStateBl模块接口规范  

提供的服务（供接口）  

|**WareKeeperBillStateBl.getToDoList**|	|
|:----|:---|
|语法|	public String[] getToDoList()
|前置条件|	仓库管理人员要查看待处理列表
|后置条件|读取并解析仓库管理人员待处理列表的信息
|**WareKeeperBillStateBl.getUnpassedList**	||
|语法|	public String[] getUnpassedList()
|前置条件|	仓库管理人员要查看未通过审核列表
|后置条件|	读取并解析仓库管理人员未通过审核列表的信息
|**WareKeeperBillStateBl. getDoneList**	||
|语法|	public String[] getDoneList()
|前置条件|仓库管理人员要查看处理完成列表
|  后置条件|	读取并解析仓库管理人员处理完成列表的信息
|**SalesmanBillStateBl.getToDoList**|	|
|语法|	public String[] getToDoList()
|前置条件	|销售进货人员要查看待处理列表
|后置条件|	读取并解析销售进货人员待处理列表的信息
|**SalesmanBillStateBl.getUnpassedList**|	|
|语法|	public String[] getUnpassedList()
|前置条件|	销售进货人员要查看未通过审核列表
|后置条件|	读取并解析销售进货人员未通过审核列表的信息
|**SalesmanBillStateBl.getDoneList**|	|
|语法|	public String[] getDoneList()
|前置条件	|销售进货人员要查看处理完成列表
|后置条件|	读取并解析销售进货人员处理完成列表的信息
|**FinancialStaffBillStateBl.get ToMakeList**|	|
|语法|	public String[] getToMakeList()
|前置条件|	财务人员要查看待制定列表
|后置条件|	读取并解析财务人员待制定列表的信息
|**FinancialStaffBillStateBl.getUnpassedList**|	|
|语法|	public String[] getUnpassedList()
|前置条件|	财务人员要查看未通过审核列表
|后置条件|	读取财务人员未通过审核列表的信息
|**FinancialStaffBillStateBl.getToDoList**|	|
|语法|	public String[ ] getToDoList()
|前置条件|财务人员要查看待处理列表
|后置条件|	读取财务人员待处理列表
|**FinancialStaffBillStateBl.getDoneList**|	|
|语法|	public String[ ] getDoneList()
|前置条件|	财务人员要查看已完成列表
|后置条件|	读取财务人员已完成列表

需要的服务接口（需接口）  

|服务名||
|:---|:---|
|billBl.GetBillBl.getBillList|	在数据库中读出所需要的数据
|billBl.GetBillBl..getToDoBillsList	|在数据库中读出待执行的单据列表|
|billBl.GetBillBl.getTBDBillsList|	在数据库中读出未审批的单据
|billBl.GetBillBl.getDeniedBillsList|在数据库中读出未通过审核的单据列表|	
|billBl.GetBillBl.getDoneBillsList	|在数据库中读出完成的单据列表|

listBl模块接口规范  

提供的服务（供接口）  

|**SalesDetailsListBl.getBills**|	|
|:---|:----|
|语法|	public SalesDetailsListVO getBills( )
|前置条件|	财务人员点击查看销售明细表按钮
|后置条件|	读取销售出货单列表
|**BusinessProcessListBl.getBills**	||
|语法|	public BusinessProcessListVO getBills( )
|前置条件|	财务人员点击查看经营历程表按钮
|后置条件|	读取所有单据列表
|**BusinessConditionListBl.getBills**|	|
|语法|	public BusinessConditionListVO getBills( )
|前置条件|	财务人员点击查看经营情况表按钮
|后置条件|	读取销售单、进货退货单、
|**NewModifyBillBl.submitBill**	||
|语法|	public void submitBill(InventoryWarningBillVO toSubmit)
|前置条件|	财务人员填完库存警戒单的红冲单据信息并提交
|后置条件|	将红冲单据保存至文件并提交总理审核
|**NewModifyBillBl.submitBill**	||
|语法|	public void submitBill (InventoryWarningBillVO toSubmit)
|前置条件	|财务人员填完库存报溢单的红冲单据信息并提交
|后置条件|	将红冲单据保存至文件并提交总理审核
|**NewModifyCopyBl.submitBill**	||
|语法|	public void submitBill(InventoryOverBill VO toSubmit )
|前置条件	|财务人员填完红冲并复制单据信息并提交
|后置条件|	将红冲并复制单据保存至文件并提交总经理审核

需要的服务接口（需接口）  

|服务名||
|:---|:---|
|billBl.GetBillBl.getBillList|	在数据库中找到需要的单据
|billBl.CreateBillBl.createGiftBill	|在数据库中插入新建好的礼品赠送单红冲单据
|billBl.CreateBillBl.createInventoryOverBill	|在数据库中插入新建好的库存报溢单红冲单据
|billBl.CreateBillBl.createInventoryWarningBill	|在数据库中插入新建好的库存警戒单红冲单据
|billBl.CreateBillBl.createInventoryLossBill	|在数据库中插入新建好的库存报损单红冲单据
|billBl.CreateBillBl.createPurchaseBill	|在数据库中插入新建好的进货单红冲单据
|billBl.CreateBillBl.createPurchaseReturnBill	|在数据库中插入新建好的进货退货单红冲单据
|billBl.CreateBillBl.createSalesBill	|在数据库中插入新建好的销售单红冲单据
|billBl.CreateBillBl.createSalesReturnBill	|在数据库中插入新建好的销售退货单红冲单据
|billBl.CreateBillBl.createReceiptBill	|在数据库中插入新建好的收款单红冲单据
|billBl.CreateBillBl.createPaymentBill	|在数据库中插入新建好的付款单红冲单据
|billBl.CreateBillBl.createCashBill	|在数据库中插入新建好的现金费用单红冲单据

financeBl模块接口规范  

提供的服务（供接口）  

|**ViewBankAccountsBl.getAccounts**	||
|:----|:----|
|语法|	public ArrayList<BankAccountVO> getAccounts()
|前置条件|	财务人员点击账户管理按钮
|后置条件|	读取银行账户列表
|**ViewBankAccountsBl.updateAccount**||
|语法|public void updateAccount(BankAccountVO oldAccount, BankAccountVO newAccount)
|前置条件|	财务人员修改完账户名称
|后置条件|	更改文件中相应的账户名称
|**ViewBankAccountsBl.deleteAccount**||
|语法|	public void deleteAccount(BankAccountVO toDetele)
|前置条件|	财务人员删除某个银行账户
|后置条件|	把该银行账户从文件中删除
|**NewBankAccountsBl.saveAccount**|	|
|语法|	public void saveAccount(bankAccountVO toSave)
|前置条件|	财务人员填写新建银行账户的信息
|后置条件	|保存银行账户到文件
|**NewReceiptBillBlService.submitReceiptBill**||
|语法|	public void saveAndSubmintReceiptBill(ReceiptBillVO toSave)
|前置条件|	财务人员填写完收款单信息
|后置条件|	将收款单保存至文件并提交总经理审核
|**NewPaymentBillBlService.submitPaymentBill**|	|
|语法|public void submintPaymentBill(PaymentBillVO toSave)
|前置条件|	财务人员填写完付款单信息
|后置条件|	将付款单保存至文件并提交总经理审核
|**NewCashExpenseBillBl.submitCashExpense**|	|
|语法|	public void submitCashExpenseBill(CashExpenseBillVO toSave)
|前置条件|	财务人员填写完现金费用单信息
|后置条件|	将现金费用单保存至文件
|**ViewInOutListBl.getInOut**|	|
|语法	|public InOutVO getInOuts( )
|前置条件|	财务人员查看账单列表
|后置条件|	读取账单列表信息并返回
|**ViewInitialInformationBl.getInitialInfo**||
|语法|	public InitialInfoVO getInitialInfo(String inOutYear)
|前置条件|	财务人员要查看期初信息
|后置条件|	读取某套账的期初信息
|**ViewInOutDetails.getDetails**||
|语法|	public InOutDetailsVO getDetails(String inOutYear)
|前置条件|	财务人员要查看某套账的明细
|后置条件|	读取某套账的明细
|**ViewInOutDetails.autoAddEntry**|	|
|语法|	public void autoAddEntry (SingleEntryVO toAdd)
|前置条件|	发生交易出现收支
|后置条件|保存该笔交易的信息到本套账的明细文件
|**NewInOutBl.saveInOut**|	|
|语法|	public void saveInOut(InitialInfoVO initialInfo)
|前置条件|	财务人员填完期初信息
|后置条件|	保存该套账的期初信息

需要的服务接口（需接口）

|服务名||
|:----|:---|
|ViewBankAccountsBlHelper.getAccountsHelper|读取账户列表的具体实现
|ViewBankAccountsBlHelper.updateAccountHelper|更新账户名称的具体实现
|ViewBankAccountsBlHelper.deleteAccountHelper|删除账户的具体实现
|NewBankAccountsBlHelper.saveAccountHelper|新建账户的具体实现
|ViewInOutListBl.getInOutHelper|读取账单列表的具体实现
|ViewInitialInformationBl.getInitialInfoHelper|读取期初信息的具体实现
|ViewInOutDetails.getDetailsHelper|读取账单信息具体实现|
|ViewInOutDetails.autoAddEntryHelper|自动增加账单信息具体实现
|NewInOutBl.saveInOutHelper|新建账单具体实现
|financeDataService.readBills|	在数据库中读取账单信息
|financeDataService.insert(ReceiptPO toInsert)	|在数据库中保存新建的收款单和付款单信息
|financeDataService.insert(CashExpensePO toInsert)	|在数据库中保存新建的现金费用单信息
|billBl.CreateBillBl.createReceiptBill	|在数据库中插入新建好的收款单
|billBl.CreateBillBl.createPaymentBill	|在数据库中插入新建好的付款单
|billBl.CreateBillBl.createCashBill	|在数据库中插入新建好的现金费用单

financeAccountsBlHelper模块接口规范  

提供的服务（供接口）  

|**ViewBankAccountsBlHelper.getAccountsHelper**	||
|:----|:----|
|语法|	public ArrayList<BankAccountVO> getAccountsHelper()
|前置条件|	财务人员点击账户管理按钮
|后置条件|	读取银行账户列表
|**ViewBankAccountsBlHelper.updateAccountHelper**||
|语法|public void updateAccountHelper(BankAccountVO oldAccount, BankAccountVO newAccount)
|前置条件|	财务人员修改完账户名称
|后置条件|	更改文件中相应的账户名称
|**ViewBankAccountsBlHelper.deleteAccountHelper**||
|语法|	public void deleteAccountHelper(BankAccountVO toDetele)
|前置条件|	财务人员删除某个银行账户
|后置条件|	把该银行账户从文件中删除
|**NewBankAccountsBlHelper.saveAccountHelper**|	|
|语法|	public void saveAccountHelper(BankAccountVO toSave)
|前置条件|	财务人员填写新建银行账户的信息
|后置条件	|保存银行账户到文件
|**ViewInOutListBl.getInOutHelper**|	|
|语法	|public InOutVO getInOutsHelper( )
|前置条件|	财务人员查看账单列表
|后置条件|	读取账单列表信息并返回
|**ViewInitialInformationBl.getInitialInfoHelper**||
|语法|	public InitialInfoVO getInitialInfoHelper(String inOutYear)
|前置条件|	财务人员要查看期初信息
|后置条件|	读取某套账的期初信息
|**ViewInOutDetails.getDetailsHelper**||
|语法|	public InOutDetailsVO getDetailsHelper(String inOutYear)
|前置条件|	财务人员要查看某套账的明细
|后置条件|	读取某套账的明细
|**ViewInOutDetails.autoAddEntryHelper**|	|
|语法|	public void autoAddEntryHelper(SingleEntryVO toAdd)
|前置条件|	发生交易出现收支
|后置条件|保存该笔交易的信息到本套账的明细文件
|**NewInOutBl.saveInOutHelper**|	|
|语法|	public void saveInOutHelper(InitialInfoVO initialInfo)
|前置条件|	财务人员填完期初信息
|后置条件|	保存该套账的期初信息

需要的服务

（需接口）

|服务名||
|:------|:------|
|financeDataService.readAccounts|在数据库中读取银行账户信息
|financeDataService.insert(BankAccountPO toInsert)|在数据库中保存新建的银行账户信息
|financeDataService.insert(SingleEntryPO toInsert)	|在数据库中当年的账本中插入该笔交易信息
|financeDataService.insert(InOutPO toInsert)	|在数据库中保存新建的账单
|financeDataService.updateAccounts(String oldAccountName, String newAccountName)	|在数据库中更新被修改的银行账户信息
|financeDataService.delete(String toDelete)	|在数据库中删除需要被删除的银行账户信息

approveBillBl的接口规范   

*提供的服务（供接口）*  

|**approveBillBl.getBillsList**| |
| :--- | :--- |
|语法| public ArrayList<BillsVo> getBillsList()|
|前置条件|存在未审批单据   |
|后置条件|传回未审批单据列表   |
|**approveBillBl.passBills**| |
|语法| public bool passBills(String billName, String billId)|
|前置条件|已有选中审批通过单据单据   |
|后置条件|该批单据被划分为审批通过单据，将其分配到工作人员，并完成数据更新   |
|**approveBillBl.denyBills**| |
|语法| public bool denyBills((String billName, String billId)|
|前置条件|已有选中单据   |
|后置条件|该批单据被划分为审批未通过单据|

*需要的服务（需接口）*  

|服务名 |服务 |
| :--- | :--- |
| billBl.toPassedBills(String  billName,String billId)|将该批单据划分为审批通过单据|
| billBl.toDeniedBills(String  billName,String billId)|将该批单据划分为审批通过单据|
| billBl.processBills(String  billName,String billId)|将审批通过单据库存数据和客户应收应付数据更新| 


billBl的接口规范    

*提供的服务（供接口）*  

| **billBl.processBillBl.processBills** | |
| :--- | :--- |
|语法| public bool processPassedBill(String  billName,String billId)|
|前置条件| 无  |
|后置条件| 将审批通过单据库存数据和客户应收应付数据更新 |
|**billBl.processBillBl.passBill** | |
|语法| public bool passBill(String  billName,String billId)|
|前置条件|无 |
|后置条件|将该批单据划分为审批通过单据|
| **billBl.processBillBl.denyBill** | |
|语法| public bool denyBill(String  billName,String billId)|
|前置条件| 无  |
|后置条件|将该批单据划分为审批通过单据|
| **billBl.processBillBl.doneBill** | |
|语法| public bool doneBill(String  billName,String billId)|
|前置条件| 无  |
|后置条件|将该批单据划分为已经完成单据|
| **billBl.processBillBl.hideBill** | |
|语法| public bool hideBill(String  billName,String billId)|
|前置条件| 无  |
|后置条件|将该批单据划分为已完成但不显示单据单据|
| **billBl.GetBillBl.getBill** | |
|语法| public BillVo getBill(String billName,String billId)|
|前置条件| 无  |
|后置条件|得到某个具体单据|
| **billBl.GetBillBl.getBillList** | |
|语法| public ArrayList<BillVo> getBillList(String billState)|
|前置条件| 无  |
|后置条件|得到某个类型和状态的具体单据|
| **billBl.GetBillBl.getBillList** | |
|语法| public ArrayList<BillVo> getBillList(String billState,String billName)|
|前置条件| 无  |
|后置条件|得到某个类型和状态的具体单据|
|**billBl.GetBillBl.getTBDBillsList** | |
|语法| public ArrayList<BillVo> getTBDBillsList(String userName,String userId,UserRole userRole)|
|前置条件| 无  |
|后置条件|得到该人员制定未审批的单据|
| **billBl.GetBillBl..getToDoBillsList** | |
|语法| public ArrayList<BillVo> .getToDoBillsList(String userName,String userId,UserRole userRole)|
|前置条件| 无  |
|后置条件|得到该人员制定通过审批但未完成的单据|
| **billBl.GetBillBl.getDeniedBillsList** | |
|语法| public ArrayList<BillVo> getDeniedBillsList(String userName,String userId,UserRole userRole)|
|前置条件| 无  |
|后置条件|得到该人员制定审批未通过的单据|
| **billBl.GetBillBl.getDoneBillsList** | |
|语法| public ArrayList<BillVo> getDoneBillsList(String userName,String userId,UserRole userRole)|
|前置条件| 无  |
|后置条件|得到该人员完成操作的单据|
|**billBl.CreateBillBl.createGiftBill**| |
|语法| public bool createGiftBill(GiftBillVo bill)|
|前置条件|无   |
|后置条件|创建一张新的库存赠送单  |
|**billBl.CreateBillBl.createInventoryOverBill**| |
|语法| public bool createInventoryOverBill(InventoryOverBillVo bill)|
|前置条件|无   |
|后置条件|创建一张新的库存报溢单  |
|**billBl.CreateBillBl.createInventoryWarningBill**| |
|语法| public bool createInventoryWarningBill(InventoryWarningBillVo bill)|
|前置条件|无   |
|后置条件|创建一张新的库存报警单  |
|**billBl.CreateBillBl.createInventoryLossBill**| |
|语法| public bool createInventoryLossBill(InventoryLossBillVo bill)|
|前置条件|无   |
|后置条件|创建一张新的库存报损单  |
|**billBl.CreateBillBl.createPurchaseBill**| |
|语法| public bool createPurchaseBill(PurchaseBillVo bill)|
|前置条件|无   |
|后置条件|创建一张新的进货单  |
|**billBl.CreateBillBl.createPurchaseReturnBill**| |
|语法| public bool createPurchaseReturnBill(PurchaseReturnBillVo bill)|
|前置条件|无   |
|后置条件|创建一张新的进货退货单  |
|**billBl.CreateBillBl.createSalesBill**| |
|语法| public bool createSalesBill(SalesBillVo bill)|
|前置条件|无   |
|后置条件|创建一张新的销售单  |
|**billBl.CreateBillBl.createSalesReturnBill**| |
|语法| public bool createSalesReturnBill(SalesReturnBillVo bill)|
|前置条件|无   |
|后置条件|创建一张新的销售退货单  |
|**billBl.CreateBillBl.createReceiptBill**| |
|语法| public bool createReceiptBill(ReceiptBillVo bill)|
|前置条件|无   |
|后置条件|创建一张新的收款单  |
|**billBl.CreateBillBl.createPaymentBill**| |
|语法| public bool createPaymentBill(PaymentBillVo bill)|
|前置条件|无   |
|后置条件|创建一张新的付款单  |
|**billBl.CreateBillBl.createCashBill**| |
|语法| public bool createCashBill(CashBillVo bill)|
|前置条件|无   |
|后置条件|创建一张新的现金费用单  |


*需要的服务（需接口）*  

|服务名 |服务 |
| :--- | :--- |
|commodityBlService.GoodsInforService.goodsAmountModify(String goodsID,int amount)|改变某几个商品数量|
|CustomerBl.addCommodity(CustomerPo[] commodity,int nums[])|修改某几个客户的应收应付数据|
|billDataService.GetBillService.getBill(String billName,String billId)|得到某一个具体单据|           |
|billDataService.GetBillService.getTBDbillsList()| 得到未审批单据列表 |
|billDataService.GetBillService.getPassedBillsList()| 得到通过单据列表  |
|billDataService.GetBillService.getDeniedBillsList()|  得到未通过单据列表 |
|billDataService.GetBillService.getTBDbillsList(String category)| 得到某一类未审批单据列表  |
|billDataService.GetBillService.getPassedBillsList(String category)| 得到某一类通过单据列表 |
|billDataService.GetBillService.getDeniedBillsList(String category)| 得到某一类未通过单据列表  |
|billDataService.ProcessBillService.changeBillState(BillPo bill,String from,String to)|将某一个单据状态改变     |
|billDataService.CreateBillServise.createGiftBill(GiftBillPo bill)||
|billDataService.CreateBillServise.createInventoryOverBill(InventoryOverBillPo bill)||
|billDataService.CreateBillServise.createInventoryWarningBill(InventoryWarningBillPo bill)||
|billDataService.CreateBillServise.createInventoryLossBill(InventoryLossBillPo bill)||
|billDataService.CreateBillServise.createPurchaseBill(PurchaseBillPo bill)||
|billDataService.CreateBillServise.createPurchaseReturnBill(PurchaseReturnBillPo bill)||
|billDataService.CreateBillServise.createSalesBill(SalesBillPo bill)||
|billDataService.CreateBillServise.createSalesReturnBill(SalesReturnBillPo bill)||
|billDataService.CreateBillServise.createReceiptBill(ReceiptBillPo bill)||
|billDataService.CreateBillServise.createPaymentBill(PaymentBillPo bill)||
|billDataService.CreateBillServise.createcashExpenseBill(cashExpenseBillPo bill)||

promotionBl的接口规范  


*提供的服务（供接口）*  

| **promotionBl.getUserStrategyList**| |
| :--- | :--- |
|语法| public ArrayList<UserStrategyVo> getUserStrategyList()|
|前置条件|存在用户促销策略 |
|后置条件|得到用户促销策略列表 |
| **promotionBl.getTotalStrategyList**| |
|语法| public ArrayList<TotalStrategyVo> getTotalStrategyList()|
|前置条件|存在总价促销策略 |
|后置条件|得到总价促销策略列表 |
| **promotionBl.getComoboStrategyList**| |
|语法| public ArrayList<ComoboStrategyVo> getComoboStrategyList()|
|前置条件|存在总价促销策略 |
|后置条件|得到总价促销策略列表 |
| **promotionBl.deleteStrategy**| |
|语法| public bool deleteStrategy(String strategyType ,String strategyId)|
|前置条件|存在该促销策略 |
|后置条件|删除该促销策略 |
| **promotionBl.addUserStrategy**| |
|语法| public bool addUserStrategy(UserStrategyVo strategy)|
|前置条件| |
|后置条件|新建该用户促销策略 |
| **promotionBl.addTotalStrategy**| |
|语法| public bool addTotalStrategy(TotalStrategyVo strategy)|
|前置条件| |
|后置条件|新建该总价促销策略 |
| **promotionBl.addComoboStrategy**| |
|语法| public bool addComoboStrategy(ComoboStrategyVo strategy)|
|前置条件| |
|后置条件|新建该组合促销策略 |

*需要的服务（需接口）*  

|服务名 |服务 |
| :--- | :--- |
|promotionService.getUserStrategyList()|得到用户促销策略列表|
|promotionDataService.getTotalStrategyList()|得到总价促销策略列表 |
|promotionDataService.getComoboStrategyList()|得到组合促销策略列表 |
|promotionDataService.deleteStrategy(String strategyType ,String strategyId)| 删除某一个促销策略|
|promotionDataService.addUserStrategy(UserStrategyPo strategy)|新增某一个用户促销策略 |
|promotionDataService.addTotalStrategy(TotalStrategyPo strategy)| 新增某一个总价促销策略|
|promotionDataService.addComoboStrategy(ComoboStrategyPo strategy)|新增某一个组合促销策略 |

adminBl的接口规范  

*提供的服务（供接口）*  

|**adminBl.getUser**| |
| :--- | :--- |
|语法| public UserVo getUser(String name,String userId)|
|前置条件|存在该用户   |
|后置条件|得到该用户信息    |
| **adminBl.addUser**| |
|语法| public bool addUser(UserVo user)|
|前置条件|不存在该用户   |
|后置条件|新增该用户    |
| **adminBl.deleteUser**| |
|语法| public bool deleteUser(String name,String Id)|
|前置条件|存在该用户   |
|后置条件|删除该用户    |
| **adminBl.updateUser**| |
|语法| public bool updateUser(UserVo user)|
|前置条件|存在该用户   |
|后置条件|更新该用户信息    |

*需要的服务（需接口）*  

|服务名 |服务 |
| :--- | :--- |
|UserDataService.getUser(String name,String userId)| 得到某一个用户信息   |
|UserDataService.addUser(UserVo user)|增加某一个用户|
|UserDataService.deleteUser(String name,String Id)|删除某一个用户|
|UserDataService.updateUser(UserVo user)|更新某一个用户信息|


---------------------------------------------------------  

###**5.4、数据层分解**  
数据层主要给业务逻辑层提供数据访问服务，包括对持久化数据的增、删、改、查。例如，financeBl业务逻辑需要由financeDataService接口提供服务。持久化数据的保存以序列化文件形式。  

####**5.4.1、模块职责**  

|模块|职责|
| :--- | :-- |
|commodityData|仓库管理数据包,包含仓库管理需要的所有数据类|
|commodityData.GoodsClassificationData|管理商品类别数据|
|commodityData.GoodsData|管理商品数据|
|commodityData.StockInOutRecord|管理出入库情况信息数据|
| userDataService | 持久化数据库的接口，提供增加用户、数据载入等服务 |
| customerDataService | 持久化数据库的接口，提供集体载入、增、删、改、查等服务 |
|financeDataService|持久化数据库的接口，提供对财务人员数据的增、删、改、查服务|
|  billDataService|提供单据操作服务|
| promotionDataService|提供制定删除产看促销策略服务|
| UserDataService|提供用户管理|
| promotionBlService|负责实现促销策略制定删除的服务|
|approveBlService|提供审批单据的服务|
####**5.4.2、接口规范**  

commodityData.GoodsClassificationData模块的接口规范  

*提供的服务（供接口）*  
*提供的服务（供接口）*  

|**GoodsClassificationData.finds**| |
| :--- | :--- |
|语法|public ArrayList< ClassificationPO > finds();|
|前置条件|无|
|后置条件|返回所有类别对象的ArrayList|
|**GoodsClassificationData.find**||
|语法|public ClassifiacationPO find(String classificationTag);|
|前置条件|类别数据文件中存在该标识的类别对象|
|后置条件|返回相应的类别对象po|
|**GoodsClassificationData.insert**||
|语法|public boolean insert(ClassificationPO po);|
|前置条件|类别数据文件中不存在同ID的类别对象|
|后置条件|在类别数据文件中插入一个新的类别po对象，返回插入成功boolean|
|**GoodsClassificationData.delete**||
|语法|public boolean delete(ClassificationPO po);|
|前置条件|类别数据文件中已存在同ID的类别对象|
|后置条件|在类别数据文件中删除该类别po对象,返回删除成功的boolean|
|**GoodsClassificationData.update**||
|语法|public boolean update(ClassificationPO po);|
|前置条件|类别数据文件中已存在同ID的类别对象|
|后置条件|在类别数据文件中更新该类别对象po，返回更新成功的boolean|

commodityData.GoodsData模块的接口规范  

*提供的服务（供接口）*  

|**GoodsData.finds**| |
| :--- | :--- |
|语法|public ArrayList< GoodsPO > finds();|
|前置条件|无|
|后置条件|返回商品数据文件中所有商品对象po的ArrayList|
|**GoodsData.fuzzyFinds**||
|语法|public ArrayList< GoodsPO > fuzzyFinds(String keyWord);|
|前置条件|无|
|后置条件|返回商品数据文件中ID是keyword或名称中含keyword的商品对象po的ArrayList，若没有相关的商品对象，则返回ArrayList为NULL|
|**GoodsData.find**||
|语法|public GoodsPO find(String goodsID);|
|前置条件|商品数据文件中存在该标识的商品对象|
|后置条件|返回同ID的商品对象po|
|**GoodsData.find**||
|语法|public GoodsPO find(String goodsName,String goodsType);|
|前置条件|商品数据文件中存在该名称和型号的商品对象（一个商品的唯一性由它的名称加型号共同决定）|
|后置条件|返回同名称、型号的商品对象po|
|**GoodsData.insert**||
|语法|public boolean insert(GoodsPO po);|
|前置条件|商品数据文件中不存在同ID的商品对象|
|后置条件|在商品数据文件中插入该商品对象po,并返回插入成功的boolean|
|**GoodsData.delete**||
|语法|public boolean delete(GoodsPO po);|
|前置条件|商品数据文件中已存在同ID的商品对象|
|后置条件|在商品数据文件中删除该商品对象po，并返回删除成功的boolean|
|**GoodsData.update**||
|语法|public boolean update(GoodsPO po);|
|前置条件|商品数据文件中已存在同ID的商品对象|
|后置条件|在商品数据文件中更新该商品对象po，并返回更新成功的boolean|

commodityData.StockInOutRecord模块的接口规范  

*提供的服务（供接口）*  

|**StockInOutRecord.finds**| |
| :--- | :--- |
|语法|public ArrayList< StockInOutPO > finds(String date);|
|前置条件|出入库情况数据文件中存在该日期的出入库情况信息对象po|
|后置条件|返回该日期的出入库情况信息对象po的ArrayList|
|**StockInOutRecord.finds**||
|语法|public ArrayList< StockInOutPO > finds(String beginTime,String endTime);|
|前置条件|出入库情况数据文件中存在该段时间内的出入库情况信息对象po|
|后置条件|返回该时间段内的出入库情况信息对象po的ArrayList|
|**StockInOutRecord.insert**||
|语法|public boolean insert(StockInOutPO po);|
|前置条件|无|
|后置条件|在出入库情况数据文件中插入一条出入库信息对象po，并返回插入成功boolean|

userDataService模块的接口规范  

*提供的服务（供接口）*  

| **userDataService.insert** |  |
| :--- | :--- |
| 语法 | public void insert(UserPo po) throws RemoteException |
| 前置条件 | 同样ID的PO在Mapper中不存在 |
| 后置条件 | 在数据库中增加一个PO记录 |
| **userDataService.find** |  |
| 语法 | public userPO find(String number, String password) throws RemoteException |
| 前置条件 | 无 |
| 后置条件 | 按ID进行查找返回相应的userPO结果 |
| **userDataService.init** |  |
| 语法 | public void init() throws RemoteException |
| 前置条件 | 无 |
| 后置条件 | 初始化持久化数据库 |
| **userDataService.finish** |  |
| 语法 | public void finish() throws RemoteException |
| 前置条件 | 无 |
| 后置条件 | 结束持久化数据库的引用 |

customerDataService模块的接口规范  

*提供的服务（供接口）*  

| **customerDataService.insert** |  |
| :--- | :--- |
| 语法 | public void insert(CustomerPo po) throws RemoteException |
| 前置条件 | 同样ID的PO在Mapper中不存在 |
| 后置条件 | 在数据库中增加一个PO记录 |
| **customerDataService.delete** |  |
| 语法 | public void delete(String number, String name) throws RemoteException |
| 前置条件 | 在数据库中存在同样ID的PO |
| 后置条件 | 删除一个PO |
| **customerDataService.update** |  |
| 语法 | public void update(CustomerPo po) throws RemoteException |
| 前置条件 | 在数据库中存在同样ID的PO |
| 后置条件 | 更新一个PO |
| **customerDataService.find** |  |
| 语法 | public customerPO find(String name) throws RemoteException |
| 前置条件 | 无 |
| 后置条件 | 按ID进行查找返回相应的customerPO结果 |
| **customerDataService.init** |  |
| 语法 | public void init() throws RemoteException |
| 前置条件 | 无 |
| 后置条件 | 初始化持久化数据库 |
| **customerDataService.finish** |  |
| 语法 | public void finish() throws RemoteException |
| 前置条件 | 无 |
| 后置条件 | 结束持久化数据库的引用 |

financeDataService模块接口规范  

提供的服务（供接口）  

|**financeDataService.readAccounts**|	|
|:----|:----|
|语法|	Public ArrayList<BankAccountPO> readAccounts()
|前置条件|	无|
|后置条件	|读取所有银行账户信息并返回bankAccountsPO的集合
|**financeDataService.readInOutList**|	|
|语法|	public String[] readInOutList()
|前置条件|无
|后置条件|读取所有账单信息并返回billPO的集合
|**financeDataService.insert(BankAccountPO toInsert)**|	|
|语法|	public void insert(BankAccountPO toInsert)
|前置条件|	数据库中不存在同名的银行账户
|后置条件|	在数据库中插入新增的银行账户信息
|**financeDataService.insert(ReceiptBillPO toInsert)**|	|
|语法|	public void insert (ReceiptBillPO toInsert) 
|前置条件|	无
|后置条件|	在数据库中插入新增的收付款单信息
|**financeDataService.insert(PaymentBillPO toInsert)**|	|
|语法|	public void insert (PaymentBillPO toInsert) 
|前置条件	|无
|后置条件|	在数据库中插入新增的收付款单信息
|**financeDataService.insert(CashExpenseBillPO toInsert)**|	|
|语法|	public void insert (CashExpenseBillPO toInsert)
|前置条件|	无
|后置条件|	在数据库中插入新增的现金费用单信息
|**financeDataService.insert(SingleEntryPO toInsert)**|	|
|语法|	public void insert (SingleEntryPO toInsert)
|前置条件|	无
|后置条件|	在数据库中插入单笔账的信息
|**financeDataService.insert(InitialInfoPO toInsert)**|	|
|语法|	public void insert (InitialInfoPO toInsert)
|前置条件	|无|
|后置条件|	在数据库中插入新建的账单|
|**financeDataService.updateAccounts(BankAccountPO oldAccount, BankAccountPO newAccount)**|	|
|语法|public void updateAccounts(BankAccountPO oldAccount,BankAccountPO newAccount)|
|前置条件|	数据库中存在与oldAccount名称相同的银行账户|
|后置条件|	更改数据库中的相应银行账户名称|
|**financeDataService.delete(BankAccountPO toDelete)**|	|
|语法|	public void delete(BankAccountPO toDelete)
|前置条件|	数据库中存在要删除的银行账户
|后置条件|	删除数据库中相应的银行账户

billDataService的接口规范    

*提供的服务（供接口）*  

| **billDataService.GetBillDataService.getBill**| |
| :--- | :--- |
|语法| public BillVo getBill(String billName,String billId)|
|前置条件| 无  |
|后置条件|得到某个具体单据|
| **billDataService.GetBillDataService.getBillList** | |
|语法| public ArrayList<BillVo> getBillList(String billState)|
|前置条件| 无  |
|后置条件|得到某个类型和状态的具体单据|
| **billDataService.GetBillDataService.getBillList** | |
|语法| public ArrayList<BillVo> getBillList(String billState,String billName)|
|前置条件| 无  |
|后置条件|得到某个类型和状态的具体单据|
| **billDataService.GetBillDataService.getTBDBillsList** | |
|语法| public ArrayList<BillVo> getTBDBillsList(String userName,String userId,UserRole userRole)|
|前置条件| 无  |
|后置条件|得到该人员制定未审批的单据|
| **billDataService.GetBillDataService..getToDoBillsList** | |
|语法| public ArrayList<BillVo> .getToDoBillsList(String userName,String userId,UserRole userRole)|
|前置条件| 无  |
|后置条件|得到该人员制定通过审批但未完成的单据|
| **billDataService.GetBillDataService.getDeniedBillsList** | |
|语法| public ArrayList<BillVo> getDeniedBillsList(String userName,String userId,UserRole userRole)|
|前置条件| 无  |
|后置条件|得到该人员制定审批未通过的单据|
| **billDataService.GetBillDataService.getDoneBillsList** | |
|语法| public ArrayList<BillVo> getDoneBillsList(String userName,String userId,UserRole userRole)|
|前置条件| 无  |
|后置条件|得到该人员完成操作的单据|
|**billDataService.ProcessBillBlService.changeBillState**| |
|语法| public bool changeBillState(BillPo bill,String from,String to)|
|前置条件|无   |
|后置条件|更改bill是否审批状态  |
|**billDataService.CreateBillBlService.createGiftBill**| |
|语法| public bool createGiftBill(GiftBillPo bill)|
|前置条件|无   |
|后置条件|创建一张新的库存赠送单  |
|**billDataService.CreateBillBlService.createInventoryOverBill**| |
|语法| public bool createInventoryOverBill(InventoryOverBillPo bill)|
|前置条件|无   |
|后置条件|创建一张新的库存报溢单  |
|**billDataService.CreateBillBlService.createInventoryWarningBill**| |
|语法| public bool createInventoryWarningBill(InventoryWarningBillPo bill)|
|前置条件|无   |
|后置条件|创建一张新的库存报警单  |
|**billDataService.CreateBillBlService.createInventoryLossBill**| |
|语法| public bool createInventoryLossBill(InventoryLossBillPo bill)|
|前置条件|无   |
|后置条件|创建一张新的库存报损单  |
|**billDataService.CreateBillBlService.createPurchaseBill**| |
|语法| public bool createPurchaseBill(PurchaseBillPo bill)|
|前置条件|无   |
|后置条件|创建一张新的进货单  |
|**billDataService.CreateBillBlService.createPurchaseReturnBill**| |
|语法| public bool createPurchaseReturnBill(PurchaseReturnBillPo bill)|
|前置条件|无   |
|后置条件|创建一张新的进货退货单  |
|**billDataService.CreateBillBlService.createSalesBill**| |
|语法| public bool createSalesBill(SalesBillPo bill)|
|前置条件|无   |
|后置条件|创建一张新的销售单  |
|**billDataService.CreateBillBlService.createSalesReturnBill**| |
|语法| public bool createSalesReturnBill(SalesReturnBillPo bill)|
|前置条件|无   |
|后置条件|创建一张新的销售退货单  |
|**billDataService.CreateBillBlService.createReceiptBill**| |
|语法| public bool createReceiptBill(ReceiptBillPo bill)|
|前置条件|无   |
|后置条件|创建一张新的收款单  |
|**billDataService.CreateBillBlService.createPaymentBill**| |
|语法| public bool createPaymentBill(PaymentBillPo bill)|
|前置条件|无   |
|后置条件|创建一张新的付款单  |
|**billDataService.CreateBillBlService.createcashExpenseBill**| |
|语法| public bool createCashExpenseBill(cashExpenseBillPo bill)|
|前置条件|无   |
|后置条件|创建一张新的现金费用单  |

promotionDataService的接口规范  

*提供的服务（供接口）*  

|**promotionDataService.getUserStrategyList**| |
| :--- | :--- |
|语法| public ArrayList<UserStrategyPo> getUserStrategyList()|
|前置条件|无   |
|后置条件|得到用户促销策略列表  |
| **promotionDataService.getTotalStrategyList**| |
|语法| public ArrayList<TotalStrategyPo> getTotalStrategyList()|
|前置条件|无   |
|后置条件|得到总价促销策略列表  |
|**promotionDataService.getComboStrategyList**| |
|语法| public ArrayList<ComboStrategyPo> getComboStrategyList()|
|前置条件|无   |
|后置条件|得到组合促销策略列表  |
| **promotionDataService.deleteStrategy**| |
|语法| public bool deleteStrategy(String strategyType ,String strategyId)|
|前置条件|无   |
|后置条件|删除某一促销策略  |
|**promotionDataService.addUserStrategy**| |
|语法| public addUserStrategy(UserStrategyVo strategy)|
|前置条件|无   |
|后置条件|增加用户促销策略 |
| **promotionDataService.addComboStrategy**| |
|语法| public addComboStrategy(ComboStrategyVo strategy)|
|前置条件|无   |
|后置条件|增加组合促销策略 |
| **promotionDataService.addTotalStrategy**| |
|语法| public addTotalStrategy(TotalStrategyVo strategy)|
|前置条件|无   |
|后置条件|增加总额促销策略 |

userDataService的接口规范  

*提供的服务（供接口）*  

| **userDataService.isValidUser** |  |
| :--- | :--- |
| 语法 | public boolean isValidUser(String userId, String password) |
| 前置条件 | 无 |
| 后置条件 | 按ID进行查找返回并判断是否为合法用户（存在该用户且密码正确） |
| **userDataService.registerUser** |  |
| 语法 | public boolean registerUser(String userId, String password) |
| 前置条件 | 无 |
| 后置条件 | 以该员工Id注册一个账户 |
| **userDataService.changePassword** |  |
| 语法 | public boolean registerUser(String userId,String oldPassword ,String newPassword) |
| 前置条件 | 无 |
| 后置条件 | 更改该员工的密码 |
|**UserDataService.getUser**| |
|语法| public UserPo getUser(String userId)|
|前置条件|存在该用户   |
|后置条件|得到该用户信息    |
|**UserDataService.addUser**| |
|语法| public boolean addUser(UserPo user)|
|前置条件|不存在该用户   |
|后置条件|新增该用户    |
|**UserDataService.deleteUser**| |
|语法| public boolean deleteUser(String Id)|
|前置条件|存在该用户   |
|后置条件|删除该用户    |
|**UserDataService.updateUser**| |
|语法| public boolean updateUser(UserPo user)|
|前置条件|存在该用户   |
|后置条件|更新该用户信息    |







##6、信息视角  
###6.1、数据持久化对象  

系统的PO类就是对应的相关的实体类，在此只做简单介绍

|名称|组成|
| :--- | :--- |
|GoodsPO|包含商品信息名称、编号、所属类别、型号、库存、进价、零售价、最新进价、最新零售价|
|ClassificationPO|包括类别名称、编号、所属父类别、子类别列表、商品列表|
|StockInOutPO|包括操作员、时间、商品编号、出入库数量|
|CustomerPO|包含客户的编号、分类、级别、姓名、电话、地址、邮编、电子邮箱、应收额度、应收、应付、默认业务员属性。
 |PurchaseBillPO|包含供应商进货单的单据编号，供应商，仓库，操作员，入库商品列表，备注，总额合计属性。
 |PurchaseReturnBillPO| 类包含供应商进货退货单的单据编号，供应商，仓库，操作员，入库商品列表，备注，总额合计属性。
 |SalesBillPO|包含销售商出货单的单据编号，客户，业务员，操作员，仓库，出货商品清单，折让前总额，折让，使用代金券金额，折让后总额，备注属性。
 |SalesReturnBillPO|包含销售商出货退货单的单据编号，客户，业务员，操作员，仓库，出货商品清单，折让后总额，备注属性。
|UserStrategyPO|编号 针对用户等级  折扣  代金券  赠品清单 开始日期   结束日期| 
|TotalStrategyPO|编号 总额额度   折扣  代金券  赠品清单 开始日期   结束日期|
|ComboStrategyPO|编号 组合名称  组合清单  折扣  开始日期 结束日期|
|UserPO|编号  姓名   职位(库存管理人员 销售员 销售经理 财务人员 财务总监 总经理 管理员) 年龄 介绍  |
|BankAccountPO|包括银行账户名称、账户余额|
|ReceiptBillPO|包括单据编号、操作员、银行账户、条目清单、总额、日期、备注。其中条目清单包括条目名、金额、备注|
|PaymentBillPO|包括单据编号、操作员、银行账户、条目清单、总额、日期、备注。其中条目清单包括条目名、金额、备注|
|CashExpenseBillPO|包括单据编号、操作员、银行账户、条目清单、总额、日期、备注。其中条目清单包括条目名、金额、备注|
|SalesDetailsListPO|包括销售单据对象和进货单据对象|
|BusinessProcessListPO|包括库存报警单、库存报溢单、库存报损单对象、进货单、进货退货单、销售单、销售退货单、收款单、付款单、现金费用单、礼物赠送单对象|
|BusinessConditionListPO|包括收款单、付款单、库存报溢单、库存报损单单据对象|
|SingleEntryPO|包括事件、金额、所属账单|
|InOutDetailsPO|包括所有账单条目|


 

###6.2  
以序列化形式存储数据，无具体格式  
###6.3各种表项  
包括出入库情况表、经营情况表、经营历程表、销售明细表  













