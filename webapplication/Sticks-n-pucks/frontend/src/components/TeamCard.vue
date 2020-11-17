<template>
    <div class="m-8 max-w-sm rounded overflow-hidden shadow-lg">
        <img class="w-full" src="../../public/logo.png" alt="logo">
        <div class="h-48 lg:h-auto lg:w-48 flex-none bg-cover rounded-t lg:rounded-t-none lg:rounded-l text-center overflow-hidden"
             style="background-image: url('../../public/logo.png')">
        </div>
        <div class="border-r border-b border-l border-gray-400 lg:border-l-0 lg:border-t lg:border-gray-400 bg-white rounded-b lg:rounded-b-none lg:rounded-r p-4 flex flex-col justify-between leading-normal">
            <div class="mb-8">
                <div class="text-gray-900 font-bold text-xl mb-2">{{ name }}</div>
                <p class="text-gray-700 text-base"> {{ description }} </p>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "TeamCard",
        props: {
            name: {
                type: String,
                required: true,
            },
            description: {
                type: String,
                required: true,
            },
        }
    };
</script>

<style scoped>
    @tailwind base;
    @tailwind components;
    @tailwind utilities;

    .chart-container {
        position: relative;
        height: 100%;
        width: 100%;
    }
</style>