/*
 * Copyright 2015 Joseph W Becher <jwbecher@drazisil.com>
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package drazisil.biomecompass.items;

import cpw.mods.fml.common.registry.GameRegistry;
import drazisil.biomecompass.BiomeCompass;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ItemBiomeCompass2 extends ItemBiomeCompassBase {

    public ItemBiomeCompass2() {
        super();

        /*
         Set name
          */
        setUnlocalizedName(BiomeCompass.MODID + "_biomeCompass_2");

        /*
         Make available in creative mode
          */
        setCreativeTab(CreativeTabs.tabMisc);

        // This compass can tp
        setHasTP(true);

    }

    @Override
    public boolean hasEffect(ItemStack par1ItemStack, int pass){
        return true;
    }

    @Override
    public void registerRecipes() {
        super.registerRecipes();
        ItemBiomeCompass1 itemBiomeCompass1 = new ItemBiomeCompass1();
        GameRegistry.addRecipe(new ItemStack(GameRegistry.findItem(BiomeCompass.MODID, getUnlocalizedName())),
                "zxz",
                "xyx",
                "zxz",
                'x', new ItemStack(Items.ender_eye),
                'y', new ItemStack(GameRegistry.findItem(BiomeCompass.MODID, itemBiomeCompass1.getUnlocalizedName())),
                'z', new ItemStack(Blocks.obsidian));

    }


}
