package store.vxdesign.cg.core.cycloid.utilities.handlers;

import store.vxdesign.cg.core.cycloid.utilities.OS;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.SelectBox;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class SkinHandler {
    public final BitmapFont font;
    public final Label.LabelStyle labelStyle;
    public final Slider.SliderStyle sliderStyle;
    public final SelectBox.SelectBoxStyle selectBoxStyle;
    public final TextField.TextFieldStyle textfieldStyle;

    private final Pixmap sliderBackground;
    private final Pixmap sliderKnob;
    private final Pixmap scrollPaneBackground;
    private final Pixmap scrollPaneScroll;
    private final Pixmap scrollPaneScrollKnob;
    private final Pixmap listSelection;
    private final Pixmap selectBoxBackground;
    private final Pixmap textfieldCursor;
    private final Pixmap textfieldSelection;
    private final Pixmap textfieldBackground;

    private final int fontSize;

    public SkinHandler() {
        OS os = OS.getOS();
        fontSize = os != null ? os.getFontSize() : 28;

        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/font.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.size = (int) (fontSize * Gdx.graphics.getDensity());
        fontParameter.color = new Color(50 / 255f, 50 / 255f, 50 / 255f, 1f);
        font = fontGenerator.generateFont(fontParameter);

        labelStyle = new Label.LabelStyle(font, new Color(5 / 255f, 5 / 255f, 5 / 255f, 1f));

        sliderBackground = new Pixmap(1, 10, Pixmap.Format.RGB565);
        sliderBackground.setColor(new Color(50 / 255f, 50 / 255f, 50 / 255f, 1f));
        sliderBackground.fill();
        TextureRegionDrawable sliderBackgroundDrawable = new TextureRegionDrawable(new TextureRegion(new Texture(sliderBackground)));

        sliderKnob = new Pixmap(10, 20, Pixmap.Format.RGB565);
        sliderKnob.setColor(new Color(1 / 255f, 1 / 255f, 1 / 255f, 1f));
        sliderKnob.fill();
        TextureRegionDrawable sliderKnobDrawable = new TextureRegionDrawable(new TextureRegion(new Texture(sliderKnob)));

        sliderStyle = new Slider.SliderStyle(sliderBackgroundDrawable, sliderKnobDrawable);

        scrollPaneBackground = new Pixmap(1, 1, Pixmap.Format.RGB565);
        scrollPaneBackground.setColor(new Color(250 / 255f, 250 / 255f, 250 / 255f, 1f));
        scrollPaneBackground.fill();
        TextureRegionDrawable scrollPaneBackgroundDrawing = new TextureRegionDrawable(new TextureRegion(new Texture(scrollPaneBackground)));

        scrollPaneScroll = new Pixmap(10, 10, Pixmap.Format.RGB565);
        scrollPaneScroll.setColor(new Color(200 / 255f, 200 / 255f, 200 / 255f, 1f));
        scrollPaneScroll.fill();
        TextureRegionDrawable scrollPaneScrollDrawing = new TextureRegionDrawable(new TextureRegion(new Texture(scrollPaneScroll)));

        scrollPaneScrollKnob = new Pixmap(10, 10, Pixmap.Format.RGB565);
        scrollPaneScrollKnob.setColor(new Color(1 / 255f, 1 / 255f, 1 / 255f, 1f));
        scrollPaneScrollKnob.fill();
        TextureRegionDrawable scrollPaneScrollKnobDrawing = new TextureRegionDrawable(new TextureRegion(new Texture(scrollPaneScrollKnob)));

        listSelection = new Pixmap(1, 1, Pixmap.Format.RGB565);
        listSelection.setColor(new Color(150 / 255f, 225 / 255f, 225 / 255f, 1f));
        listSelection.fill();
        TextureRegionDrawable listSelectionDrawing = new TextureRegionDrawable(new TextureRegion(new Texture(listSelection)));

        selectBoxBackground = new Pixmap(1, 1, Pixmap.Format.RGB565);
        selectBoxBackground.setColor(new Color(235 / 255f, 235 / 255f, 235 / 255f, 1f));
        selectBoxBackground.fill();
        TextureRegionDrawable selectBoxBackgroundDrawing = new TextureRegionDrawable(new TextureRegion(new Texture(selectBoxBackground)));

        ScrollPane.ScrollPaneStyle scrollPaneStyle = new ScrollPane.ScrollPaneStyle(scrollPaneBackgroundDrawing,
                scrollPaneScrollDrawing, scrollPaneScrollKnobDrawing, scrollPaneScrollDrawing, scrollPaneScrollKnobDrawing);
        List.ListStyle listStyle = new List.ListStyle(font, Color.WHITE, Color.WHITE, listSelectionDrawing);
        selectBoxStyle = new SelectBox.SelectBoxStyle(font, Color.WHITE, selectBoxBackgroundDrawing, scrollPaneStyle, listStyle);

        textfieldCursor = new Pixmap(1, 1, Pixmap.Format.RGB565);
        textfieldCursor.setColor(new Color(1 / 255f, 1 / 255f, 1 / 255f, 0.75f));
        textfieldCursor.fill();
        TextureRegionDrawable textfieldCursorDrawable = new TextureRegionDrawable(new TextureRegion(new Texture(textfieldCursor)));

        textfieldSelection = new Pixmap(1, 1, Pixmap.Format.RGB565);
        textfieldSelection.setColor(new Color(1f, 1f, 1f, 0.75f));
        textfieldSelection.fill();
        TextureRegionDrawable textfieldSelectionDrawable = new TextureRegionDrawable(new TextureRegion(new Texture(textfieldSelection)));

        textfieldBackground = new Pixmap(1, 1, Pixmap.Format.RGB565);
        textfieldBackground.setColor(235 / 255f, 235 / 255f, 235 / 255f, 1f);
        textfieldBackground.fill();
        TextureRegionDrawable textfieldBackgroundDrawable = new TextureRegionDrawable(new TextureRegion(new Texture(textfieldBackground)));

        textfieldStyle = new TextField.TextFieldStyle(font, Color.WHITE, textfieldCursorDrawable, textfieldSelectionDrawable, textfieldBackgroundDrawable);
    }

    public void dispose() {
        sliderBackground.dispose();
        sliderKnob.dispose();
        scrollPaneBackground.dispose();
        scrollPaneScroll.dispose();
        scrollPaneScrollKnob.dispose();
        listSelection.dispose();
        selectBoxBackground.dispose();
        textfieldCursor.dispose();
        textfieldSelection.dispose();
        textfieldBackground.dispose();
        font.dispose();
    }
}
