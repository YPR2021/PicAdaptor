## PicAdaptor
图片适配器,让PicAdaptorLayout这个类在xml中包裹住想要适配的ImageView,
设置一些通常的属性就可以了.对外提供了设置宽高比和相对于谁计算宽高的方法.也可以直接在xml中修改
eg:
```java
    <!--rlRatio,可以自己在这里设置宽高比和相对与谁计算-->
    <com.yangpeiru.picadaptorlibrary.PicAdaptorLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="6dp"
        app:rlRatio="2.43"
        app:rlRelative="width">

        <ImageView
            android:id="@+id/main_iv_pic"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:src="@mipmap/ic_launcher"/>

    </com.yangpeiru.picadaptorlibrary.PicAdaptorLayout>
```
