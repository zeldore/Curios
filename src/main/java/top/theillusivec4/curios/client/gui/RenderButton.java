/*
 * Copyright (c) 2018-2020 C4
 *
 * This file is part of Curios, a mod made for Minecraft.
 *
 * Curios is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Curios is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Curios.  If not, see <https://www.gnu.org/licenses/>.
 */

package top.theillusivec4.curios.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import javax.annotation.Nonnull;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.util.ResourceLocation;
import top.theillusivec4.curios.common.inventory.CurioSlot;

public class RenderButton extends ImageButton {

  private final ResourceLocation resourceLocation;
  private final int yTexStart;
  private final int xTexStart;
  private final CurioSlot slot;

  public RenderButton(CurioSlot slot, int xIn, int yIn, int widthIn, int heightIn, int xTexStartIn,
      int yTexStartIn, int yDiffTextIn, ResourceLocation resourceLocationIn,
      Button.IPressable onPressIn) {
    super(xIn, yIn, widthIn, heightIn, xTexStartIn, yTexStartIn, yDiffTextIn, resourceLocationIn,
        256, 256, onPressIn);
    this.resourceLocation = resourceLocationIn;
    this.yTexStart = yTexStartIn;
    this.xTexStart = xTexStartIn;
    this.slot = slot;
  }

  @Override
  public void func_230431_b_(@Nonnull MatrixStack matrixStack, int mouseX, int mouseY,
      float partialTicks) {
    // NO-OP
  }

  public void renderButtonOverlay(@Nonnull MatrixStack matrixStack, int mouseX, int mouseY,
      float partialTicks) {
    Minecraft minecraft = Minecraft.getInstance();
    minecraft.getTextureManager().bindTexture(this.resourceLocation);
    RenderSystem.disableDepthTest();
    int j = this.xTexStart;

    if (!slot.getRenderStatus()) {
      j += 8;
    }
    func_238463_a_(matrixStack, this.field_230690_l_, this.field_230691_m_, (float) j,
        (float) this.yTexStart, this.field_230688_j_, this.field_230689_k_, 256, 256);
    RenderSystem.enableDepthTest();
  }
}
