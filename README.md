# exep2
实验2
# Android 布局实验

## 项目概述

本项目是 Android 界面布局的综合性实验，涵盖了 Android 开发中主流的五种布局方式，包括传统 XML 布局和现代 Jetpack Compose 声明式 UI。

## 开发环境

| 项目 | 版本 |
|------|------|
| Android Gradle Plugin | 9.4.0 |
| Gradle | 9.6.0 |
| Kotlin | 2.2.10 |
| Jetpack Compose BOM | 2026.02.01 |
| compileSdk / targetSdk | 37 |
| minSdk | 24 |
| JDK | 17 |

## 实验列表

### 1. 线性布局（LinearLayout）

使用嵌套 `LinearLayout` 实现 **4×4 网格**界面，通过 `layout_weight` 实现等分布局。

- **Activity**: `LinearActivity`
- **布局文件**: `res/layout/activity_linear.xml`

### 2. 表格布局（TableLayout）

使用 `TableLayout` 实现**菜单列表**界面，展示图标、文字和快捷键。

- **Activity**: `TableActivity`
- **布局文件**: `res/layout/activity_table.xml`

### 3. 约束布局 1（ConstraintLayout — 计算器）

使用 `ConstraintLayout` 实现**计算器界面**，包含显示区域和 4×4 数字键盘。

- **Activity**: `Constraint1Activity`
- **布局文件**: `res/layout/activity_constraint1.xml`

### 4. 约束布局 2（ConstraintLayout — 仪表盘）

使用 `ConstraintLayout` + `CardView` 实现**仪表盘界面**，包含 Tab、开关、旋钮和地图占位。

- **Activity**: `Constraint2Activity`
- **布局文件**: `res/layout/activity_constraint2.xml`

### 5. Jetpack Compose（任务列表）

使用 **Jetpack Compose** 实现课程任务列表，支持添加、删除和勾选完成状态。

- **Activity**: `ComposeTaskActivity`
- **实现方式**: 完全使用 Compose 声明式 UI（`LazyColumn` + `Material3`）

## 项目结构

```
app/src/main/
├── AndroidManifest.xml
├── java/com/example/myapplication/
│   ├── LauncherActivity.kt       # 主入口（导航菜单）
│   ├── LinearActivity.kt         # 线性布局实验
│   ├── TableActivity.kt          # 表格布局实验
│   ├── Constraint1Activity.kt    # 约束布局1（计算器）
│   ├── Constraint2Activity.kt    # 约束布局2（仪表盘）
│   └── ComposeTaskActivity.kt    # Compose 任务列表
└── res/
    ├── layout/
    │   ├── activity_launcher.xml
    │   ├── activity_linear.xml
    │   ├── activity_table.xml
    │   ├── activity_constraint1.xml
    │   └── activity_constraint2.xml
    └── values/
        ├── strings.xml
        ├── colors.xml
        └── themes.xml
```

## 构建与运行

### 命令行构建

```powershell
# 需要先设置 JAVA_HOME 为 Android Studio 自带 JBR（JDK 25）
$env:JAVA_HOME = "D:\Android\Android Studio\jbr"
$env:PATH = "$env:JAVA_HOME\bin;$env:PATH"

# Debug APK
.\gradlew.bat assembleDebug

# Release APK
.\gradlew.bat assembleRelease
```

### Android Studio

1. 用 Android Studio 打开项目根目录
2. 等待 Gradle Sync 完成
3. 选择运行配置 → 点击 ▶ Run

APK 输出路径：`app/build/outputs/apk/debug/app-debug.apk`

## 参考资料

- [Android 官方布局文档](https://developer.android.google.cn/guide/topics/ui/declaring-layout.html)
- [Jetpack Compose 官方文档](https://developer.android.com/develop/ui/compose)
