package de.devsnx.survivalgames.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionType;

public class ItemCreator {

    private Material mat;

    private Short data;

    private Integer amount;

    private String display;

    private List<String> lore;

    private Map<Enchantment, Integer> enchantments = new HashMap<Enchantment, Integer>();

    private Potion potion;

    public ItemCreator() {}

    public ItemCreator(ItemStack item) {
        this.mat = item.getType();
        this.data = Short.valueOf(item.getDurability());
        this.amount = Integer.valueOf(item.getAmount());
        if (item.hasItemMeta()) {
            if (item.getItemMeta().hasDisplayName())
                this.display = item.getItemMeta().getDisplayName();
            if (item.getItemMeta().hasLore())
                this.lore = item.getItemMeta().getLore();
            if (item.getItemMeta().hasEnchants())
                this.enchantments = item.getItemMeta().getEnchants();
        }
    }

    public ItemCreator material(Material mat) {
        this.mat = mat;
        return this;
    }

    public ItemCreator data(short data) {
        this.data = Short.valueOf(data);
        return this;
    }

    public ItemCreator amount(int amount) {
        this.amount = Integer.valueOf(amount);
        return this;
    }

    public ItemCreator displayName(String display) {
        this.display = display;
        return this;
    }

    public ItemCreator lore(List<String> lore) {
        this.lore = lore;
        return this;
    }

    public ItemCreator addEnchant(Enchantment ench, int level) {
        this.enchantments.put(ench, Integer.valueOf(level));
        return this;
    }

    public ItemCreator removeEnchant(Enchantment ench) {
        if (!this.enchantments.containsKey(ench))
            return this;
        this.enchantments.remove(ench);
        return this;
    }

    public ItemCreator asPotion(PotionEffect effect, boolean splash) {
        Potion potion = new Potion(PotionType.getByEffect(effect.getType()));
        potion.getEffects().add(effect);
        potion.setLevel(effect.getAmplifier());
        potion.setSplash(splash);
        this.potion = potion;
        return this;
    }

    public Material getMaterial() {
        return this.mat;
    }

    public Short getData() {
        return this.data;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public String getDisplayName() {
        return this.display;
    }

    public List<String> getLore() {
        return this.lore;
    }

    public Map<Enchantment, Integer> getEnchantments() {
        return this.enchantments;
    }

    public boolean isPotion() {
        return (this.potion != null);
    }

    public Potion getPotion() {
        return this.potion;
    }

    public ItemStack build() {
        ItemStack item = null;
        if (this.mat == null && this.potion == null)
            return item;
        if (this.data == null)
            this.data = Short.valueOf((short)0);
        if (this.amount == null)
            this.amount = Integer.valueOf(1);
        if (this.potion != null) {
            item = this.potion.toItemStack(this.amount.intValue());
        } else {
            item = new ItemStack(this.mat, this.amount.intValue(), this.data.shortValue());
        }
        if (this.display != null || this.lore != null) {
            ItemMeta meta = item.getItemMeta();
            if (this.display != null)
                meta.setDisplayName(this.display);
            if (this.lore != null)
                meta.setLore(this.lore);
            item.setItemMeta(meta);
        }
        if (this.enchantments.size() > 0)
            item.addUnsafeEnchantments(this.enchantments);
        return item;
    }
}