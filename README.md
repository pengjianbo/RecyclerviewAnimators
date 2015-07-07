# RecyclerviewAnimators
RecyclerView ItemAnimator动画集
本项目针对低版本Android API兼容（[NineOldAndroids](https://github.com/JakeWharton/NineOldAndroids)）

* 源代码转载于 [recyclerview-animators](https://github.com/wasabeef/recyclerview-animators).

# Demo

### ItemAnimator
<img src="art/demo.gif" width="32%"> <img src="art/demo2.gif" width="32%"> <img src="art/demo4.gif" width="32%">

### Adapters
![](art/demo3.gif) ![](art/demo5.gif)

## ItemAnimator
### Step 1

Set RecyclerView ItemAnimator.

```java
    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
    recyclerView.setItemAnimator(new SlideInLeftAnimator());
```

### Advanced Step 2

You can change the durations.

```java
    recyclerView.getItemAnimator().setAddDuration(1000);
    recyclerView.getItemAnimator().setRemoveDuration(1000);
    recyclerView.getItemAnimator().setMoveDuration(1000);
    recyclerView.getItemAnimator().setChangeDuration(1000);
```

### Advanced Step 3

By extending AnimateViewHolder, you can override preset animation.
So, custom animation can be set depeding on view holder.

```java
   static class MyViewHolder extends AnimateViewHolder {

        public MyViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void animateRemoveImpl(ViewPropertyAnimatorListener listener) {
            ViewCompat.animate(itemView)
                    .translationY(-itemView.getHeight() * 0.3f)
                    .alpha(0)
                    .setDuration(300)
                    .setListener(listener)
                    .start();
        }

        @Override
        public void preAnimateAddImpl() {
            ViewCompat.setTranslationY(itemView, -itemView.getHeight() * 0.3f);
            ViewCompat.setAlpha(itemView, 0);
        }

        @Override
        public void animateAddImpl(ViewPropertyAnimatorListener listener) {
            ViewCompat.animate(itemView)
                    .translationY(0)
                    .alpha(1)
                    .setDuration(300)
                    .setListener(listener)
                    .start();
        }
    }
```

### Animators

#### Cool
`LandingAnimator`

##### Scale
`ScaleInAnimator`, `ScaleInTopAnimator`, `ScaleInBottomAnimator`
`ScaleInLeftAnimator`, `ScaleInRightAnimator`


##### Fade
`FadeInAnimator`, `FadeInDownAnimator`, `FadeInUpAnimator`
`FadeInLeftAnimator`, `FadeInRightAnimator`

##### Flip
`FlipInTopXAnimator`, `FlipInBottomXAnimator`
`FlipInLeftYAnimator`, `FlipInRightYAnimator`

##### Slide
`SlideInLeftAnimator`, `SlideInRightAnimator`, `OvershootInLeftAnimator`, `OvershootInRightAnimator`
`SlideInUpAnimator`, `SlideInDownAnimator`

## RecyclerView.Adapter
### Step 1

Set RecyclerView ItemAnimator.

```java
    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
    MyAdapter adapter = new MyAdapter();
    recyclerView.setAdapter(new AlphaInAnimationAdapter(adapter));

```

### Advanced Step 2

Change the durations.

```java
    MyAdapter adapter = new MyAdapter();
    AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(adapter);
    alphaAdapter.setDuration(1000);
    recyclerView.setAdapter(alphaAdapter);
```

### Advanced Step 3

Change the interpolator.

```java
    MyAdapter adapter = new MyAdapter();
    AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(adapter);
    alphaAdapter.setInterpolator(new OvershootInterpolator());
    recyclerView.setAdapter(alphaAdapter);
```

### Advanced Step 4

Disable the first scroll mode.

```java
    MyAdapter adapter = new MyAdapter();
    AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(adapter);
    scaleAdapter.setFirstOnly(false);
    recyclerView.setAdapter(alphaAdapter);
```

### Advanced Step 5

Multiple Animations

```java
    MyAdapter adapter = new MyAdapter();
    AlphaInAnimationAdapter alphaAdapter = new AlphaInAnimationAdapter(adapter);
    recyclerView.setAdapter(new ScaleInAnimationAdapter(alphaAdapter));
```

### Adapters

#### Alpha
`AlphaInAnimationAdapter`

#### Scale
`ScaleInAnimationAdapter`

#### Slide
`SlideInBottomAnimationAdapter`
`SlideInRightAnimationAdapter`, `SlideInLeftAnimationAdapter`