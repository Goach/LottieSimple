package com.goach.lottie

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.OnCompositionLoadedListener
import com.goach.lottie.anim.AnimFactory
import com.goach.lottie.utils.AssetUtils
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import timber.log.Timber
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    private val RC_FILE = 0x11
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = Adapter(AssetUtils.getJsonAssets(ctx,""),ctx){
            title ->
            lottieAnim.cancelAnimation()
            drawableLayout.closeDrawers()
            //方式1
           // AnimFactory.startAssetAnim(lottieAnim,"$title")
            //方式2
            AnimFactory.startAssetAnim(ctx,lottieAnim,"$title"){
                this.loop(true)
            }
        }

        btnAssets.onClick {
            drawableLayout.openDrawer(Gravity.START)
        }
        btnFiles.onClick {
            val intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "*/*"
            intent.addCategory(Intent.CATEGORY_OPENABLE)
            startActivityForResult(Intent.createChooser(intent,"Select a JSON file"),RC_FILE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode != Activity.RESULT_OK) return
        when(requestCode){
            RC_FILE -> onFileLoaded(data!!.data)
        }
    }
    fun onFileLoaded(uri:Uri){
        var inputStream: InputStream?= null
        try {
            when(uri.scheme){
                "file" -> {
                    inputStream  = FileInputStream(uri.path)
                }
                "content" -> {
                    inputStream = contentResolver.openInputStream(uri)
                }
                 else -> onLoadError()
            }
            lottieAnim.cancelAnimation()
            if(inputStream!=null)
            AnimFactory.startFileAnim(ctx,lottieAnim,inputStream)
        }catch (e: FileNotFoundException){
            onLoadError()
        }
    }

    private fun onLoadError() {
        Snackbar.make(drawableLayout!!, "Failed to load animation", Snackbar.LENGTH_LONG).show()
    }
    class Adapter(private val dataList:List<String> ,private val context: Context,val itemClick:((CharSequence)->Unit)? = null)
        :RecyclerView.Adapter<Adapter.AViewHolder>(){
        override fun onBindViewHolder(holder: AViewHolder, position: Int) {
            holder.itemView.find<TextView>(R.id.nav_item_title).text = dataList[position]
        }

        override fun getItemCount(): Int  = dataList.size

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AViewHolder {
           val rootView =  context.verticalLayout{
               lparams(width = matchParent,height = dip(50))
                gravity = Gravity.CENTER
                textView {
                    id = R.id.nav_item_title
                    lparams(width = wrapContent,height = wrapContent)
                    textSize = 18f
                    singleLine = true
                    ellipsize = TextUtils.TruncateAt.END
                    onClick {
                        itemClick?.invoke(text)
                    }

                }
            }
            return AViewHolder(rootView)
        }

        inner class AViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    }
}
