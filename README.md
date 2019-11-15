# SuperTextBar

[![](https://jitpack.io/v/hyzhan43/SuperTextBar.svg)](https://jitpack.io/#hyzhan43/SuperTextBar)

# Step1
```java
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```
	
# Step2
```java
dependencies {
    implementation 'com.github.hyzhan43:SuperTextBar:1.0.0'
}
```

# Step3 

```kotlin
<com.zhan.core.SuperTextBar
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:contentGravity="center"
        app:contentText="@string/white_color"
        app:leftText="@string/air_pods"
        app:leftTextSize="10sp"
        app:padding="10dp"
        app:rightText="@string/number"
        app:rightTextSize="20sp"
        app:showBottomLine="true" />
```

如需新能源车牌，则需要绑定 切换新能源车牌 View。调用 `setTriggerView` 方法.

# 更多用法

## Attributes属性（plateView布局文件中调用）
|Attributes         | Format        | Describe
|---                | ---           | ---|
showTopLine         | boolean       | 显示顶部分割线 默认`false`不显示
showBottomLine      | boolean       | 显示底部分割线 默认`false`不显示
topLineColor        | color         | 设置顶部分割线颜色 默认显示`灰色(#bdbdbd)`
bottomLineColor     | color         | 设置底部分割线颜色 默认显示`灰色(#bdbdbd)`
padding             | dimension     | 设置内间距 默认0
textSize            | dimension     | 设置统一字体大小 默认显示`子text` 大小, 如果设置了, 会优先显示。
textStyle           | enum          | 设置统一字体样式 默认显示`子text` 样式, 如果设置了, 会优先显示。

leftIcon            | reference     | 设置左边图标
leftText            | string        | 设置左边文本
leftTextSize        | dimension     | 设置左边字体大小 默认 `14sp`
leftTextColor       | color         | 设置左边字体颜色 默认 黑色
leftTextStyle       | enum          | 设置左边字体样式, Normal(正常, 默认)、Bold(粗体)、Italic(斜体)、Bold_Italic(粗体+斜体)


contentText         | string        | 设置内容文本
contentTextSize     | dimension     | 设置内容字体大小 默认 `14sp`
contentTextColor    | color         | 设置内容字体颜色 默认 黑色
contentTextStyle    | enum          | 设置内容字体样式, Normal(正常, 默认)、Bold(粗体)、Italic(斜体)、Bold_Italic(粗体+斜体)
contentGravity      | enum          | 设置内容字体对齐方式, Start(头部对齐), 默认)、Center(居中)、End(尾部对齐)

rightIcon           | reference     | 设置右边图标
rightText           | string        | 设置右边文本
rightTextSize       | dimension     | 设置右边字体大小 默认 `14sp`
rightTextColor      | color         | 设置右边字体颜色 默认 黑色
rightTextStyle      | enum          | 设置右边字体样式, Normal(正常, 默认)、Bold(粗体)、Italic(斜体)、Bold_Italic(粗体+斜体)



