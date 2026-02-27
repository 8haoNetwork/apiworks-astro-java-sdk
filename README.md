## apiworks-astro-java-sdk

Java SDK for ApiWorks 星盘 API（默认网关 `https://cloud.apiworks.com/open/astro`）。用于简化在 Java 项目中调用星盘、八字、紫微、星宿、运势、AI 报告等接口的集成工作。

### 功能概览

- **客户端**: 同步 `AstroCloudClient`、异步 `AsyncAstroCloudClient`
- **请求模型**: 与后端 DTO 对齐的简单 Java Bean（位于 `com.apiworks.astro.model.requests.*`）
  - 星盘：`com.apiworks.astro.model.requests.chart.*`
  - 运势：`com.apiworks.astro.model.requests.scope.*`
  - 八字：`com.apiworks.astro.model.requests.bazi.*`
  - 紫微：`com.apiworks.astro.model.requests.ziwei.*`
  - 星宿：`com.apiworks.astro.model.requests.naks.*`
  - 报告：`com.apiworks.astro.model.requests.report.*`
- **响应模型**: 通用 `ApiResp<T>`，以及若干常用 VO（位于 `com.apiworks.astro.model.responses.*`）

目前实现了一组与后端服务对齐的核心接口：

- 星盘：`chartNatal`、`chartTransit` 等（`/chart/*`）
- 星座：`mySign`、`signsList`、`signInfo`、`signCompat`
- 运势：`scopeDay`、`scopeWeek`、`scopeMonth`、`scopeYear`
- 八字：`baziNatal`、`baziFlow`、`baziMatch`、`baziSummary`
- 紫微：`ziweiNatal`、`ziweiChart`、`ziweiDetail`
- 星宿：`naksRelations`
- 报告：`reportRomantic`、`reportWeeklyScope`、`reportYearlyScope`、`reportTogether`、`reportWealth`、`reportGet`、`reportGetHtml`

后续可根据后端 API 文档持续补充。

### 安装（Maven）

如果已经发布到中央仓库，在你的 `pom.xml` 中添加：

```xml
<dependency>
    <groupId>com.apiworks</groupId>
    <artifactId>apiworks-astro-java-sdk</artifactId>
    <version>0.1.0</version>
</dependency>
```

如果尚未发布到中央仓库，可在本项目根目录执行 `mvn clean install` 进行本地安装，然后在业务项目中按上述方式引用。

### 快速开始（同步客户端）

```java
import com.apiworks.astro.AstroCloudClient;
import com.apiworks.astro.model.common.ApiResp;
import com.apiworks.astro.model.common.TimeAndLocation;
import com.apiworks.astro.model.requests.chart.SinglePointQry;
import com.apiworks.astro.model.responses.astro.AstroDataVo;

public class Demo {
    public static void main(String[] args) {
        AstroCloudClient client = new AstroCloudClient(
                "your-app-id",
                "your-app-key"
        );

        SinglePointQry qry = new SinglePointQry(
                new TimeAndLocation("1990-08-14 12:00:00", 8, 116.4074, 39.9042)
        );

        ApiResp<AstroDataVo> resp = client.chartNatal(qry);
        if (resp.getCode() == 0 && resp.getData() != null) {
            AstroDataVo data = resp.getData();
            // 访问 data.getPlanet() / data.getHouse() 等字段
            System.out.println(data);
        }
    }
}
```

### 快速开始（异步客户端）

```java
import com.apiworks.astro.AsyncAstroCloudClient;
import com.apiworks.astro.model.common.ApiResp;
import com.apiworks.astro.model.common.TimeAndLocation;
import com.apiworks.astro.model.requests.chart.SinglePointQry;
import com.apiworks.astro.model.responses.astro.AstroDataVo;

import java.util.concurrent.CompletableFuture;

public class AsyncDemo {
    public static void main(String[] args) throws Exception {
        AsyncAstroCloudClient client = new AsyncAstroCloudClient(
                "your-app-id",
                "your-app-key"
        );

        SinglePointQry qry = new SinglePointQry(
                new TimeAndLocation("1990-08-14 12:00:00", 8, 116.4074, 39.9042)
        );

        CompletableFuture<ApiResp<AstroDataVo>> future = client.chartNatal(qry);
        future.thenAccept(resp -> {
            if (resp.getCode() == 0 && resp.getData() != null) {
                System.out.println("planet size = " + resp.getData().getPlanet().size());
            } else {
                System.out.println("code=" + resp.getCode() + ", msg=" + resp.getMsg());
            }
        }).exceptionally(ex -> {
            ex.printStackTrace();
            return null;
        });

        // 简单等待异步完成
        Thread.sleep(5000);
    }
}
```

### 配置

```java
AstroCloudClient client = new AstroCloudClient(
        "your-app-id",
        "your-app-key",
        "https://cloud.apiworks.com/open/astro", // 可选 baseUrl
        30_000                                     // 可选超时时间（毫秒）
);
```

### API 响应格式

所有接口均返回 `ApiResp<T>`：

- `code`：0 表示成功
- `msg`：错误信息/提示
- `data`：具体业务数据 VO
- `exeTime`：接口执行耗时（秒）

可以直接通过 IDE 补全访问数据字段。

### 验证 SDK 是否可用

- 在当前项目下执行：

```bash
mvn clean install
```

- 在你的业务项目中引入本 SDK，并用真实的 `appId/appKey` 调用一次 `chartNatal` 或 `baziNatal`，确认网络与凭证正常。

### 基于真实后端运行示例（examples）

本仓库 `examples` 下提供同步示例 `SyncExample` 与异步示例 `AsyncExample`，可按以下方式**基于真实后端**验证。

**1. 用 Maven 直接跑 main**

先设置环境变量，再执行对应 main 类：

```bash
export APIWORKS_APP_ID=你的AppId
export APIWORKS_APP_KEY=你的AppKey

# 同步示例（本命盘、行运、八字、日运势、紫微、星宿、桃花报告）
mvn exec:java@run-sync-example

# 异步示例（本命盘、八字→运势链式、紫微+桃花报告并行）
mvn exec:java@run-async-example
```

也可在 IDE 中直接运行 `SyncExample` 或 `AsyncExample` 的 `main` 方法，运行前在运行配置里设置上述两个环境变量。

**2. 用集成测试验证（真实后端）**

当且仅当环境变量 `APIWORKS_APP_ID`、`APIWORKS_APP_KEY` 均已设置时，会执行针对真实后端的集成测试：

- `SyncExampleRealBackendIT`：覆盖 SyncExample 中的本命盘、行运盘、八字、日运势、紫微、星宿、桃花报告等调用。
- `AsyncExampleRealBackendIT`：覆盖 AsyncExample 中的异步本命盘、八字→运势链式、紫微与桃花报告并行等调用。

```bash
export APIWORKS_APP_ID=你的AppId
export APIWORKS_APP_KEY=你的AppKey
mvn test
```

未设置上述环境变量时，这些集成测试会被跳过，不影响仅用 Mock 的单元测试。

### License

MIT

