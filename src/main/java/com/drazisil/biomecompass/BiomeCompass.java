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

package com.drazisil.biomecompass;

import com.drazisil.biomecompass.client.items.ItemBiomeCompass;
import com.drazisil.biomecompass.client.items.ItemBiomeCompass1;
import com.drazisil.biomecompass.event.BiomeCompassEventHandler;
import com.drazisil.biomecompass.proxy.BCCommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = BiomeCompass.MODID, name = BiomeCompass.NAME, version = BiomeCompass.VERSION)
public class BiomeCompass
{
    public static final String MODID = "biomecompass";
    public static final String NAME = "Biome Compass";
    public static final String VERSION = "1.0";

    @SidedProxy(clientSide = "com.drazisil.biomecompass.proxy.BCClientProxy", serverSide = "com.drazisil.biomecompass.proxy.BCDedicatedServerProxy")
    public static BCCommonProxy proxy;

    BiomeCompassEventHandler events = new BiomeCompassEventHandler();

    @EventHandler
    public void preinit(FMLPreInitializationEvent event){
        //FMLCommonHandler.instance().bus().register(events);
        MinecraftForge.EVENT_BUS.register(events);

        ItemBiomeCompass biomeCompassItem = new ItemBiomeCompass();
        String itemBiomeCompassName = BiomeCompass.MODID + "_biomeCompass";
        GameRegistry.registerItem(biomeCompassItem, itemBiomeCompassName);

        ItemBiomeCompass biomeCompassItem1 = new ItemBiomeCompass1();
        String itemBiomeCompassName1 = BiomeCompass.MODID + "_biomeCompass1";
        GameRegistry.registerItem(biomeCompassItem1, itemBiomeCompassName1);

    }


    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
    }

    @EventHandler
    public void serverLoad(FMLServerStartingEvent event)
    {
        // com.drazisil.biomecompass.commands.BiomeCompassCommand
        //event.registerServerCommand(new BiomeCompassCommand());
    }



}
