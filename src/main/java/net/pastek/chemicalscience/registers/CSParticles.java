package net.pastek.chemicalscience.registers;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pastek.chemicalscience.ChemicalScience;

public class CSParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister
	    .create(BuiltInRegistries.PARTICLE_TYPE, ChemicalScience.MOD_ID);

    public static final DeferredHolder<ParticleType<?>, ParticleType<DustParticleOptions>> COLORED_FLAME = PARTICLES
	    .register("colored_flame", () -> new ParticleType<DustParticleOptions>(false) {
		@Override
		public MapCodec<DustParticleOptions> codec() {
		    return DustParticleOptions.CODEC;
		}

		@Override
		public StreamCodec<? super RegistryFriendlyByteBuf, DustParticleOptions> streamCodec() {
		    return DustParticleOptions.STREAM_CODEC;
		}
	    });
}
