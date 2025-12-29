/*
 * A Minecraft mod made for WinterJam 2019, contains an Xmas tree named Spruce Willis.
 * Copyright (C) KiriCattus 2013 - 2025
 * https://github.com/kiris-mods/spruce-willis-the-xmas-tree/blob/dev/LICENSE.md
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE
 */
package dev.tophatcat.sprucewillisthexmastree.platform;

import dev.tophatcat.sprucewillisthexmastree.WillisCommon;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class PlatformFabric implements IPlatform {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(WillisCommon.MOD_ID);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(
        String id, Supplier<BlockEntityType<T>> blockEntityType) {
        return registerSupplier(BuiltInRegistries.BLOCK_ENTITY_TYPE, id, blockEntityType);
    }

    @Override
    public <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> block) {
        return registerSupplier(BuiltInRegistries.BLOCK, id, block);
    }

    @Override
    public <T extends Entity> Supplier<EntityType<T>> registerEntity(String id, Supplier<EntityType<T>> entity) {
        return registerSupplier(BuiltInRegistries.ENTITY_TYPE, id, entity);
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item) {
        return registerSupplier(BuiltInRegistries.ITEM, id, item);
    }

    @Override
    public <T extends SoundEvent> Supplier<T> registerSound(String id, Supplier<T> sound) {
        return registerSupplier(BuiltInRegistries.SOUND_EVENT, id, sound);
    }

    @Override
    public <T extends CreativeModeTab> Supplier<T> registerCreativeModeTab(String id, Supplier<T> tab) {
        return registerSupplier(BuiltInRegistries.CREATIVE_MODE_TAB, id, tab);
    }

    @Override
    public <E extends Mob> Supplier<SpawnEggItem> makeSpawnEgg(
        Item.Properties itemProperties, Supplier<EntityType<E>> entityType) {
        return () -> new SpawnEggItem(itemProperties.spawnEgg(entityType.get()));
    }

    @Override
    public CreativeModeTab.Builder newCreativeTabBuilder() {
        return FabricItemGroup.builder();
    }

    @SuppressWarnings("unchecked")
    private static <T, R extends Registry<? super T>> Supplier<T> registerSupplier(
        R registry, String id, Supplier<T> object) {
        final T registeredObject = Registry.register((Registry<T>) registry, Identifier.fromNamespaceAndPath(
            WillisCommon.MOD_ID, id), object.get());
        return () -> registeredObject;
    }

    @SuppressWarnings("unchecked")
    private static <T, R extends Registry<? super T>> Holder<T> registerHolder(
        R registry, String id, Supplier<T> object) {
        return Registry.registerForHolder((Registry<T>) registry, Identifier.fromNamespaceAndPath(
            WillisCommon.MOD_ID, id), object.get());
        }
}
